package com.project.spring_study_roadmap.glabal;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

/**
 * 25.06.18 QueryDSL 공통 클래스 정의
 * 모든 QueryDSL 기반 커스텀 리포지토리에서 상속받아 사용할 수 있는 공통 추상 클래스
 */

public abstract class QueryDslSupport {

    protected final JPAQueryFactory jpaQueryFactory;
    protected final EntityManager entityManager;

    public QueryDslSupport(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
        this.entityManager = entityManager;
    }
}
