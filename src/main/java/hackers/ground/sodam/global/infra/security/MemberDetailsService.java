package hackers.ground.sodam.global.infra.security;

import hackers.ground.sodam.domain.auth.presentation.dto.res.TokenRes;
import hackers.ground.sodam.domain.thing.repository.UserRepository;
import hackers.ground.sodam.domain.user.entity.UserEntity;
import hackers.ground.sodam.global.infra.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberDetailsService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public TokenRes loadUserByUsername(String id) {
        UserEntity userEntity = userRepository.findByUserId(id);
        return jwtProvider.generateToken(id, userEntity.getUserState());
    }
}
