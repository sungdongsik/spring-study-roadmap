package com.project.spring_study_roadmap.domain.user.service;

import com.project.spring_study_roadmap.domain.user.dto.UserDto;
import com.project.spring_study_roadmap.domain.user.repository.UserRepository;
import com.project.spring_study_roadmap.glabal.error.DuplicationException;
import com.project.spring_study_roadmap.glabal.util.ResponseMessageEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void register(UserDto userDto){

        if(userRepository.existsByUserEmailAndDelYnFalse(userDto.getEmail())){
            throw new DuplicationException(ResponseMessageEnum.DUPLICATION_ERROR.getMessage());
        }
        userRepository.save(userDto.toEntity());
    }
}
