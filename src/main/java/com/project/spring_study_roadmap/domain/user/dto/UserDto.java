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
    private String email;

    /** 사용자 이름 */
    private String name;

    /** 사용자 비밀번호 (평문 또는 암호화된 상태로 전송) */
    @NotBlank
    @Size(min = 4, message = "비밀번호는 최소 4자 이상이어야 합니다.")
    private String password;

    /** 사용자 역할 (예: ROLE_USER, ROLE_ADMIN) */
    private String role;

    public void setPassword(String password) {
        this.password = password;
    }

    public static UserDto from(UserEntity userEntity){
        UserDto dto = new UserDto();
        dto.userId = userEntity.getUserId();
        dto.email = userEntity.getUserEmail();
        dto.name = userEntity.getUserName();
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
                .userEmail(this.email)
                .userName(this.name)
                .userPass(this.password)
                .role(RoleEnum.USER.getValue())
                .build();
    }
}
