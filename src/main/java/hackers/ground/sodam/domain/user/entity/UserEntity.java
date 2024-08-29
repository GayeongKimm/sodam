package hackers.ground.sodam.domain.user.entity;

import hackers.ground.sodam.global.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import hackers.ground.sodam.domain.user.enums.UserCategory;
import hackers.ground.sodam.domain.user.enums.UserState;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_user")
@DynamicUpdate
@AllArgsConstructor
public class UserEntity extends BaseTimeEntity {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_category")
    @Enumerated(EnumType.STRING)
    private UserCategory userCategory;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private UserState userState = UserState.ACTIVE;

}