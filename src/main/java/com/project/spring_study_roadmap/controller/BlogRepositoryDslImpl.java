package com.project.spring_study_roadmap.controller;

import com.project.spring_study_roadmap.dto.BlogDTO;
import com.project.spring_study_roadmap.entity.BlogEntity;
import com.project.spring_study_roadmap.entity.QBlogEntity;
import com.project.spring_study_roadmap.glabal.QueryDslSupport;
import jakarta.persistence.EntityManager;

import java.util.List;

public class BlogRepositoryDslImpl extends QueryDslSupport implements BlogRepositoryDsl {

    public BlogRepositoryDslImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<BlogEntity> findByBlogList() {
        return jpaQueryFactory.select(QBlogEntity.blogEntity)
                .from(QBlogEntity.blogEntity)
                .fetch();
    }
}
