package sodam.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import sodam.domain.user.enums.UserCategory;
import sodam.domain.user.enums.UserState;
import sodam.global.common.entity.BaseTimeEntity;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_seller")
@DynamicUpdate
@AllArgsConstructor
public class SellerEntity extends BaseTimeEntity {
    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @Column(name = "seller_open_date")
    @DateTimeFormat
    private String openDate;

    @Column(name = "seller_seller_num")
    private String sellerNum;

    @Column(name = "seller_phone_num")
    private String phoneNum;

    @Column(name = "farm_name")
    private String farmName;

    @Column(name = "farm_adress")
    private String farmAdress;

    @Column(name = "account")
    private String account;

    @Column(name = "num")
    private String num;

}
