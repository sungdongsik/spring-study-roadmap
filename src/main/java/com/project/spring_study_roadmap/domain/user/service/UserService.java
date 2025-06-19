package com.project.spring_study_roadmap.domain.user.service;

import com.project.spring_study_roadmap.domain.user.dto.UserDto;
import com.project.spring_study_roadmap.domain.user.enitiy.UserEntity;
import com.project.spring_study_roadmap.domain.user.repository.UserRepository;
import com.project.spring_study_roadmap.glabal.error.DuplicationException;
import com.project.spring_study_roadmap.glabal.util.ResponseMessageEnum;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 25.06.18 사용자 서비스
 * 사용자 정보를 처리하는 서비스입니다.
 * 사용자 등록, 조회, 수정, 삭제 등의 기능을 제공합니다.
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserDto register(@Valid UserDto userDto){

        if(userRepository.existsByUserEmailAndDelYnFalse(userDto.getUserEmail())){
            throw new DuplicationException(ResponseMessageEnum.DUPLICATION_ERROR.getMessage());
        }

        userDto.setUserPassword(passwordEncoder.encode(userDto.getUserPassword()));
        UserEntity entity = userRepository.save(userDto.toEntity());

        return UserDto.from(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UserEntity user = userRepository.findByUserEmailAndDelYnFalse(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new User(
                user.getUserEmail(), user.getUserPass(), List.of(new SimpleGrantedAuthority("USER")));
    }

    public UserDto findByUser(UserDto dto){

        UserEntity userEntity = userRepository.findByUserEmailAndDelYnFalse(dto.getUserEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return UserDto.from(userEntity);
    }
}
