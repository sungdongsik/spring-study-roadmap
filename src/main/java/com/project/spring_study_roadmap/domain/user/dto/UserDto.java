package com.project.spring_study_roadmap.domain.user.dto;


import com.project.spring_study_roadmap.domain.user.enitiy.UserEntity;
import com.project.spring_study_roadmap.glabal.util.RoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 25.06.18 사용자 DTO 클래스
 *
 * 프론트엔드로부터 전달받은 사용자 데이터를 담는 객체입니다.
 * NoArgsConstructor와 Getter를 통해 DTO로 사용
 */

@NoArgsConstructor
@Getter
public class UserDto {

    /** 사용자 고유 식별자 */
    private Long userId;

    /** 사용자 이메일 */
    @NotBlank
    @Email
    private String userEmail;

    /** 사용자 이름 */
    private String userName;

    /** 사용자 비밀번호 (평문 또는 암호화된 상태로 전송) */
    @NotBlank
    @Size(min = 4, message = "비밀번호는 최소 4자 이상이어야 합니다.")
    private String userPassword;

    /** 사용자 역할 (예: ROLE_USER, ROLE_ADMIN) */
    private String role;

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public static UserDto from(UserEntity userEntity){
        UserDto dto = new UserDto();
        dto.userId = userEntity.getUserId();
        dto.userEmail = userEntity.getUserEmail();
        dto.userName = userEntity.getUserName();
        dto.role = userEntity.getRole();
        return dto;
    }

    /**
     * DTO → Entity 변환 메서드.
     * @return UserEntity 형태의 도메인 객체
     */
    public UserEntity toEntity(){
        return UserEntity.builder()
                .userId(this.userId)
                .userEmail(this.userEmail)
                .userName(this.userName)
                .userPass(this.userPassword)
                .role(RoleEnum.USER.getValue())
                .build();
    }
}
