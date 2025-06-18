package com.project.spring_study_roadmap.domain.user.repository;

import com.project.spring_study_roadmap.domain.user.dto.UserDto;
import com.project.spring_study_roadmap.domain.user.enitiy.QUserEntity;
import com.project.spring_study_roadmap.domain.user.enitiy.UserEntity;
import com.project.spring_study_roadmap.glabal.QueryDslSupport;
import com.querydsl.core.BooleanBuilder;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.project.spring_study_roadmap.domain.user.enitiy.QUserEntity.*;

public class UserRepositoryDslImpl extends QueryDslSupport implements UserRepositoryDsl {

    public UserRepositoryDslImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public boolean findByUsers(UserDto userDto) {
        List<UserEntity> users = jpaQueryFactory.select(userEntity)
                .from(userEntity)
                .where(booleanBuilder(userDto)
                        .and(userEntity.delYn.eq('N'))
                )
                .fetch();

        return users != null;
    }


    private BooleanBuilder booleanBuilder(UserDto userDto){
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if (StringUtils.isNotBlank(userDto.getEmail())){
            booleanBuilder.and(userEntity.userEmail.eq(userDto.getEmail()));
        }

        return booleanBuilder;
    }
}
