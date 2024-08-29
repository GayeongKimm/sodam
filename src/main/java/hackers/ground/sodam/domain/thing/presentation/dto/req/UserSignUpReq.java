package hackers.ground.sodam.domain.thing.presentation.dto.req;

import jakarta.persistence.Column;

public record UserSignUpReq(
        String memberId,
        String memberName,
        String memberEmail,
        String memberPassword,
        String memberPhoneNum,
        String memberAddress
) {
}
