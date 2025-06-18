package com.project.spring_study_roadmap.glabal.util;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 25.06.18 공통 엔티티 추상 클래스
 * - 생성일, 수정일, 삭제 여부(delYn) 필드를 포함
 * - 모든 엔티티는 이 클래스를 상속받아 공통 필드를 사용
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @Column(name = "INSERT_DT", updatable = false)
    protected LocalDateTime insertDt;

    @LastModifiedDate
    @Column(name = "UPDATE_DT")
    protected LocalDateTime updateDt;

    protected char delYn = 'N';


    public void setDelYn(char delYn) {
        this.delYn = delYn;
    }
}
