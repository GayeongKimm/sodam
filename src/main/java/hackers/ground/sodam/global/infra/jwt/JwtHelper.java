package hackers.ground.sodam.global.infra.jwt;

import hackers.ground.sodam.domain.thing.repository.UserRepository;
import hackers.ground.sodam.domain.user.entity.UserEntity;
import hackers.ground.sodam.global.infra.security.CustomMemberDetails;
import hackers.ground.sodam.global.properties.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class JwtHelper {

    private final UserRepository memberRepository;
    private final JwtProperties jwtProperties;

    @Transactional
    public Authentication getAuthentication(String accessToken) {
        Claims claims = getClaims(accessToken);
        UserEntity userEntity = memberRepository.findByUserId(claims.getSubject());

        CustomMemberDetails details = new CustomMemberDetails(userEntity);

        return new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(jwtProperties.getSecretKey()).build().parseClaimsJws(token).getBody();
    }

    public String extractToken(final String token) {
        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            return token.substring(7);
        }
        return token;
    }

}
