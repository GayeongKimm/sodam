package sodam.global.infra.jwt;

import sodam.domain.user.entity.UserEntity;
import sodam.domain.user.repository.UserRepository;
import sodam.global.infra.security.CustomMemberDetails;
import sodam.global.properties.JwtProperties;
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

    private final UserRepository userRepository;
    private final JwtProperties jwtProperties;

    @Transactional
    public Authentication getAuthentication(String accessToken) {
        Claims claims = getClaims(accessToken);
        UserEntity user = userRepository.findByUserId(claims.getSubject());

        CustomMemberDetails details = new CustomMemberDetails(user);

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
