package sodam.domain.auth.presentation.dto.req;

public record SignInReq(
        String memberId,
        String memberPassword
) {
}
