package hackers.ground.sodam.global.infra.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import hackers.ground.sodam.domain.user.entity.UserEntity;

@Component
public class GetCurrentMember {
    public UserEntity current() {
        return getMemberDetails().user();
    }

    private CustomMemberDetails getMemberDetails() {
        return ((CustomMemberDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
