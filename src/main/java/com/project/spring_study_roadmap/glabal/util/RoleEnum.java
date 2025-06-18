package com.project.spring_study_roadmap.glabal.util;

/**
 * 25.06.18 ADMIN, USER ENUM 클래스입니다.
 */

public enum RoleEnum {
    ADMIN("ADMIN", 0000),

    USER("USER", 0001),

    ;

    private String value;

    private int statusCode;

    RoleEnum(String message, int statusCode) {
        this.value = message;
        this.statusCode = statusCode;
    }

    public String getValue() {
        return value;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
