package com.project.spring_study_roadmap.glabal.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 25.06.18 QueryDSL 설정 클래스입니다.
 * JPAQueryFactory를 Bean으로 등록하여 전역에서 주입받아 사용할 수 있도록 구성합니다.
 * EntityManager를 사용하여 QueryDSL 기반의 쿼리 생성을 지원합니다.
 */

@Configuration
public class QueryDslConfig {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory(){
        return new JPAQueryFactory(entityManager);
    }
}
