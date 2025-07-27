package com.project.spring_study_roadmap.domain.user.repository;

import com.project.spring_study_roadmap.domain.user.enitiy.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryDsl{
    boolean existsByUserEmailAndDelYnFalse(String userEmail);

    Optional<UserEntity> findByUserEmailAndDelYnFalse(String userEmail);
}
