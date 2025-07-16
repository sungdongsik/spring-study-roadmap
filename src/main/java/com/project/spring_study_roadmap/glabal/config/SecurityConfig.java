//package com.project.spring_study_roadmap.glabal.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.List;
//
//import static org.springframework.security.config.Customizer.*;
//
///**
// * 25.06.18 Spring Security 설정 클래스
// * Spring Boot 3.x 이상의 환경에 맞춰 SecurityFilterChain을 구성합니다.
// * - CORS 및 CSRF 설정
// * - 인증 없이 접근 가능한 경로 설정 (/api/auth/**, OPTIONS 요청 등)
// * - 그 외 요청은 인증 필요
// * - CORS 정책은 별도의 Bean으로 구성하여 프론트엔드와의 연동을 지원합니다.
// */
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // CSRF 비활성화
//                .cors(withDefaults())         // CORS 설정 적용
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()  // OPTIONS 허용
//                        .requestMatchers("/api/auth/**").permitAll()             // 회원가입, 로그인 등 허용
//                        .anyRequest().authenticated()                            // 나머지 인증 필요
//                )
//                .httpBasic(withDefaults()); // 또는 formLogin 등 필요에 따라 변경
//
//        return http.build();
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowedOrigins(List.of("http://localhost:3000")); // 프론트 주소
//        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        config.setAllowedHeaders(List.of("*"));
//        config.setAllowCredentials(true); // credentials: 'include' 사용 시 필요
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config);
//
//        return source;
//    }
//}
