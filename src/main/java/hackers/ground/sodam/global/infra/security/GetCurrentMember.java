package hackers.ground.sodam.global.infra.security;

import hackers.ground.sodam.domain.user.entity.UserEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class GetCurrentMember {
    public UserEntity current() {
        return getMemberDetails().user();
    }

    private CustomMemberDetails getMemberDetails() {
        return ((CustomMemberDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
