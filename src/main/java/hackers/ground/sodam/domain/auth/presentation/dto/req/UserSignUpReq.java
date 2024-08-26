package hackers.ground.sodam.domain.auth.presentation.dto.req;

public record UserSignUpReq(
        String memberId,
        String memberPassword,
        String memberEmail,
        String memberName,
        String memberPhoneNum,
        String memberAuthCode,
        String memberAddress
) {
}
