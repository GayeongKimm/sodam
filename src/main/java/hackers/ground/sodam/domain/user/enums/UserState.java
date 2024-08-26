package hackers.ground.sodam.domain.user.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserState {
    ACTIVE("ROLE_ACTIVE"),
    DELETED("ROLE_DELETED");
    private final String key;
}
