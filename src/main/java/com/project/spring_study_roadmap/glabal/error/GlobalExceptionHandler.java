package com.project.spring_study_roadmap.glabal.error;

import com.project.spring_study_roadmap.glabal.util.ApiResponse;
import com.project.spring_study_roadmap.glabal.util.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleAll() {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse<>(false, null, ResponseMessage.SERVER_ERROR.getMessage()));
    }
}
