package hackers.ground.sodam.domain.thing.presentation.dto.res;

import hackers.ground.sodam.domain.thing.entity.ThingEntity;
import hackers.ground.sodam.domain.thing.enums.ThingCategory;
import hackers.ground.sodam.domain.user.entity.SellerEntity;

public record ThingRes(
        String name,

        String wantMoney,

        ThingCategory Category,

        String farmName
) {
    public static ThingRes of(ThingEntity thingEntity, SellerEntity sellerEntity) {
        return new ThingRes(
                thingEntity.getName(),
                thingEntity.getWantMoney(),
                thingEntity.getCategory(),
                sellerEntity.getFarmName()
        );
    }
}
