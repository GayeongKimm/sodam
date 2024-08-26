package hackers.ground.sodam.global.infra.jwt;

import hackers.ground.sodam.global.properties.JwtProperties;
import hackers.ground.sodam.domain.auth.presentation.dto.res.TokenRes;
import hackers.ground.sodam.domain.user.enums.UserState;
import hackers.ground.sodam.domain.user.repository.UserRepository;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import hackers.ground.sodam.global.error.custom.auth.WithdrawalMemberException;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    private final JwtProperties jwtProperties;
    private final UserRepository userRepository;

    public TokenRes generateToken(String id, final UserState userState) {
        if(userRepository.findByUserId(id).getUserState()== UserState.DELETED){
            throw WithdrawalMemberException.EXCEPTION;
        }
        return new TokenRes(
                generateAccessToken(id, userState),
                generateRefreshToken(id, userState));
    }


    public String generateAccessToken(String id, final UserState userState) {
        return Jwts.builder()
                .setHeaderParam(Header.JWT_TYPE, JwtType.ACCESS)
                .setSubject(id)
                .claim("Authorization", userState)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getAccessExpiration()))
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecretKey())
                .compact();
    }

    public String generateRefreshToken(String id, final UserState userState) {
        return Jwts.builder()
                .setHeaderParam(Header.JWT_TYPE, JwtType.REFRESH)
                .claim("Authorization", userState)
                .setSubject(id.toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getRefreshExpiration()))
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecretKey())
                .compact();
    }
}
