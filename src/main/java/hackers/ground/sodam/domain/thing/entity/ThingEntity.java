package hackers.ground.sodam.domain.thing.entity;

import hackers.ground.sodam.domain.thing.enums.ThingCategory;
import hackers.ground.sodam.domain.user.entity.SellerEntity;
import hackers.ground.sodam.domain.user.entity.UserEntity;
import hackers.ground.sodam.global.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_thing")
@DynamicUpdate
@AllArgsConstructor
public class ThingEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean possible;

    private Integer min;

    private LocalDate arriveAt;

    private String wantMoney;

    @Enumerated
    private ThingCategory Category;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private SellerEntity sellerEntity;
}
