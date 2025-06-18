package com.project.spring_study_roadmap.domain.user.service;

import com.project.spring_study_roadmap.domain.user.dto.UserDto;
import com.project.spring_study_roadmap.domain.user.enitiy.UserEntity;
import com.project.spring_study_roadmap.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void register(UserDto userDto) throws Exception {

        userRepository.save(userDto.toEntity());
    }
}
