package com.project.spring_study_roadmap.domain.user.enitiy;

import com.project.spring_study_roadmap.glabal.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

/**
 * 25.06.18 사용자 엔티티 클래스
 *
 * BaseEntity를 상속하여 공통 생성/수정일자 및 삭제 여부(delYn)를 포함합니다.
 * 사용자 아이디, 이메일, 이름, 비밀번호, 역할 정보를 보유합니다.</p>
 *
 */

@Entity
@Table(name = "tb_user")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    /** 사용자 고유 식별자 */
    private Long userId = 1L;

    /** 사용자 이메일 */
    private String userEmail;

    /** 사용자 이름 */
    private String userName;

    /** 사용자 비밀번호 (평문 또는 암호화된 상태로 전송) */
    private String userPass;

    /** 사용자 역할 (예: ROLE_USER, ROLE_ADMIN) */
    private String role;

    /**
     * Builder 패턴을 사용하는 생성자.
     *
     * @param userId     고유 식별자 (자동 생성)
     * @param userEmail  사용자 이메일
     * @param userName   사용자 이름
     * @param userPass   암호화된 비밀번호
     * @param role       사용자 역할 (예: ROLE_USER, ROLE_ADMIN)
     */

    @Builder
    public UserEntity(Long userId, String userEmail, String userName, String userPass, String role) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPass = userPass;
        this.role = role;
    }
}
