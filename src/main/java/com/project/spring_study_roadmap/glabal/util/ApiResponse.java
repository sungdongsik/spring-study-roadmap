package com.project.spring_study_roadmap.glabal.util;


/**
 * 25.06.18  API 응답 포맷 클래스입니다.
 * API 응답 시 일관된 구조로 성공 여부(success), 응답 데이터(data), 메시지(message)를 전달합니다.
 * 프론트엔드와의 명확한 통신을 위해 사용됩니다.
 */

public class ApiResponse<T> {

    private boolean success;

    private T data;

    private String message;

    public ApiResponse(boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }


    public static <T> ApiResponse<T> success(T data, ResponseMessage responseMessage){
        return new ApiResponse<>(true, data, responseMessage.getMessage());
    }

    public static <T> ApiResponse<T> fail(ResponseMessage responseMessage){
        return new ApiResponse<>(false, null, responseMessage.getMessage());
    }
}
