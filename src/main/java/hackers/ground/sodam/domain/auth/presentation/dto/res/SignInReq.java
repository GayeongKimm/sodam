package hackers.ground.sodam.domain.auth.presentation.dto.res;

import java.time.LocalDate;

public record SignInReq(
        String memberId,
        String memberName,
        String memberEmail,
        String memberPassword,
        LocalDate openDate,
        String sellerNum,
        String phoneNum,
        String farmName,
        String farmAdress,
        String account,
        String num
) {
}
