package com.project.spring_study_roadmap.domain.user.controller;

import com.project.spring_study_roadmap.domain.user.dto.UserDto;
import com.project.spring_study_roadmap.domain.user.service.UserService;
import com.project.spring_study_roadmap.glabal.util.ApiResponse;
import com.project.spring_study_roadmap.glabal.util.ResponseMessageEnum;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
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

    @PostMapping("/register")
    public ApiResponse<UserDto> register(@RequestBody @Valid UserDto userDto){
        UserDto data = userService.register(userDto);
        return new ApiResponse<>(true, data, ResponseMessageEnum.SUCCESS.getMessage());
    }
}
