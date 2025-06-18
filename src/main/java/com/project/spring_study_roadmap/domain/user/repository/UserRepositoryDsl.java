package com.project.spring_study_roadmap.domain.user.repository;

import com.project.spring_study_roadmap.domain.user.dto.UserDto;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepositoryDsl {

    @Transactional(readOnly = true)
    boolean findByUsers(UserDto userDto);
}
