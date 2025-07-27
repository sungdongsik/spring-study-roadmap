package com.project.spring_study_roadmap.glabal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 25.06.18 Web MVC 설정 클래스
 * 프론트엔드(예: React)와의 CORS(Cross-Origin Resource Sharing) 정책을 설정합니다.
 * 모든 경로에 대해 HTTP 메서드, 헤더, 인증 정보를 허용하며,
 * preflight 요청에 대한 캐시 시간을 설정합니다.
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로
                .allowedOrigins("http://localhost:5173") // 허용할 도메인
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메서드
                .allowedHeaders("*")
                .allowCredentials(true) // 인증 정보 허용 여부 (세션, 쿠키등)
                .maxAge(3600); // preflight 요청 캐시 시간 (초)
    }
}
