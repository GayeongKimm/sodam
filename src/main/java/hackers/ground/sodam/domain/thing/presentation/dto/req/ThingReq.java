package hackers.ground.sodam.domain.thing.presentation.dto.req;

import hackers.ground.sodam.domain.thing.enums.ThingCategory;

import java.time.LocalDate;

public record ThingReq(
        String name,

        boolean possible,

        Integer min,

        LocalDate arriveAt,

        String wantMoney,

        ThingCategory Category
) {
}
