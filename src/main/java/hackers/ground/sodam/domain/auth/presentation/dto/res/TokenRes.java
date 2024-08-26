package hackers.ground.sodam.domain.auth.presentation.dto.res;

import lombok.Builder;

@Builder
public record TokenRes(
        String accessToken,
        String refreshToken
) {
}