package com.project.spring_study_roadmap.domain.user.controller;

import com.project.spring_study_roadmap.domain.user.dto.LoginResponse;
import com.project.spring_study_roadmap.domain.user.dto.UserDto;
import com.project.spring_study_roadmap.domain.user.service.UserService;
import com.project.spring_study_roadmap.glabal.config.JwtUtil;
import com.project.spring_study_roadmap.glabal.util.ApiResponse;
import com.project.spring_study_roadmap.glabal.util.ResponseMessageEnum;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * 25.06.18 사용자 컨트롤러
 * 사용자 정보를 처리하는 REST 컨트롤러입니다.
 * 사용자 등록, 조회, 수정, 삭제 등의 기능을 제공합니다.
 */

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ApiResponse<UserDto> register(@RequestBody @Valid UserDto userDto){
        UserDto data = userService.register(userDto);
        return new ApiResponse<>(true, data, ResponseMessageEnum.SUCCESS.getMessage());
    }


    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody UserDto dto) {
        // 1. 인증 처리
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUserEmail(), dto.getUserPassword())
        );

        // 2. 토큰 생성
        String token = jwtUtil.createAccessToken(dto.getUserEmail());

        UserDto byUser = userService.findByUser(dto);

        // 3. 응답 DTO 생성
        LoginResponse response = new LoginResponse(byUser, token);

        // 4. 응답 반환 (헤더에 토큰도 같이 넣을 경우, 위에 알려준 ResponseEntity 방식으로)
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .body(ApiResponse.success(response, ResponseMessageEnum.SUCCESS));
    }

}
