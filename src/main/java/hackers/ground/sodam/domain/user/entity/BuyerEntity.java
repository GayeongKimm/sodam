package hackers.ground.sodam.domain.user.entity;

import hackers.ground.sodam.global.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_buyer")
@DynamicUpdate
@AllArgsConstructor
public class BuyerEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @Column(name = "user_phone_num")
    private String phoneNum;

    @Column(name = "user_address")
    private String address;

}
