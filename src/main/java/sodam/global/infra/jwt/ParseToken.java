package sodam.global.infra.jwt;

import sodam.global.properties.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.invoke.WrongMethodTypeException;

@Component
@RequiredArgsConstructor
public class ParseToken {
    private final JwtProperties jwtProperties;
    private final JwtHelper jwtHelper;

    public String getSubjectFromRefreshToken(final String refreshToken) {
        return getSubject(refreshToken, JwtType.REFRESH);
    }

    public String getSubjectFromAccessToken(final String accessToken) {
        return getSubject(accessToken, JwtType.ACCESS);
    }

    private String getSubject(final String token, final JwtType jwtType) {
        final String key = jwtProperties.getSecretKey();

        final Jws<Claims> jwsClaims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwtHelper.extractToken(token));

        this.isWrongType(jwsClaims, jwtType);

        return jwsClaims.getBody().getSubject();
    }

    private void isWrongType(final Jws<Claims> claims, final JwtType jwtType) {
        if(!(claims.getHeader().get(Header.JWT_TYPE).equals(jwtType.toString()))) {
            throw new WrongMethodTypeException();
        }
    }
}
