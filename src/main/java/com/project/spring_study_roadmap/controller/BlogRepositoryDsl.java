package com.project.spring_study_roadmap.controller;

import com.project.spring_study_roadmap.dto.BlogDTO;
import com.project.spring_study_roadmap.entity.BlogEntity;
import com.project.spring_study_roadmap.glabal.QueryDslSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlogRepositoryDsl{

    @Transactional(readOnly = true)
    List<BlogEntity> findByBlogList();
}
