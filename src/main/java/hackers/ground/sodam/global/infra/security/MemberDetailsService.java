package hackers.ground.sodam.global.infra.security;

import hackers.ground.sodam.domain.auth.presentation.dto.res.TokenRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import hackers.ground.sodam.domain.user.entity.UserEntity;
import hackers.ground.sodam.domain.user.repository.UserRepository;
import hackers.ground.sodam.global.infra.jwt.JwtProvider;

@Component
@RequiredArgsConstructor
public class MemberDetailsService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public TokenRes loadUserByUsername(String id) {
        UserEntity memberEntity = userRepository.findByUserId(id);
        return jwtProvider.generateToken(id, memberEntity.getUserState());
    }
}
