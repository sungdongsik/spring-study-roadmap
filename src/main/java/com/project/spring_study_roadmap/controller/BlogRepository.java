package com.project.spring_study_roadmap.controller;

import com.project.spring_study_roadmap.dto.BlogDTO;
import com.project.spring_study_roadmap.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<BlogEntity, Long>, BlogRepositoryDsl {
}
