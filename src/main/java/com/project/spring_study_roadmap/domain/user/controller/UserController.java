package com.project.spring_study_roadmap.domain.user.controller;

import com.project.spring_study_roadmap.domain.user.dto.UserDto;
import com.project.spring_study_roadmap.domain.user.service.UserService;
import com.project.spring_study_roadmap.glabal.util.ApiResponse;
import com.project.spring_study_roadmap.glabal.util.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ApiResponse<UserDto> register(@RequestBody UserDto userDto) throws Exception {
        userService.register(userDto);
        return new ApiResponse<>(true, userDto, ResponseMessage.SUCCESS.getMessage());
    }
}
