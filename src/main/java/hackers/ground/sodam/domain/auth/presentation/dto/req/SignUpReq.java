package hackers.ground.sodam.domain.auth.presentation.dto.req;

public record SignUpReq(
        String memberId,
        String memberName,
        String memberPassword,
        String memberEmail,
        String openDate,
        String sellerNum,
        String phoneNum,
        String farmName,
        String farmAdress,
        String account,
        String num
) {
}
