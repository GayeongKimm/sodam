package hackers.ground.sodam.domain.auth.presentation.dto.res;

import java.time.LocalDate;

public record SignUpReq(
        String memberId,
        String memberPassword,
        String memberName,
        String memberEmail,
        LocalDate openDate,
        String sellerNum,
        String phoneNum,
        String farmName,
        String farmAdress,
        String account,
        String num
) {
}
