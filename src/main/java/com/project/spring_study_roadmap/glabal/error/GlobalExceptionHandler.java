package com.project.spring_study_roadmap.glabal.error;

import com.project.spring_study_roadmap.glabal.util.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 25.06.18 전역 예외 처리 클래스
 * 애플리케이션 전역에서 발생할 수 있는 예외를 처리하는 클래스입니다.
 * @ControllerAdvice 어노테이션을 사용하여 모든 컨트롤러에서 발생하는 예외를 잡아 처리
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<?>> badRequest(RuntimeException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>(false, null, e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> serverError(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse<>(false, null, e.getMessage()));
    }

}
