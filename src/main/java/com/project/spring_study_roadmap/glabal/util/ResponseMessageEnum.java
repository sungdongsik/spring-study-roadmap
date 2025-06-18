package com.project.spring_study_roadmap.glabal.util;

/**
 * 25.06.18  API 응답 포맷 ENUM 클래스입니다.
 */

public enum ResponseMessageEnum {
    SUCCESS("요청에 성공했습니다.", 1000),
    SERVER_ERROR("서버 오류가 발생했습니다.", 1001),
    FAIL("잘못된 요청입니다.", 1002),
    DUPLICATION_ERROR("중복된 값입니다.", 1003)
    ;


    ResponseMessageEnum(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    private String message;

    private int statusCode;

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
