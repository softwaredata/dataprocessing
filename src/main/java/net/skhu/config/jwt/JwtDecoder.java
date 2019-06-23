package net.skhu.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import net.skhu.config.security.MemberContext;
import net.skhu.exception.JwtException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

/**
 * Created by bomi on 2019-05-14.
 */

@Component
@Slf4j
public class JwtDecoder {
    @Value("${JWT.SECRET}")
    private static String SECRET;

    public MemberContext decode(String token) {
        DecodedJWT decodedJWT = isValidToken(token).orElseThrow(() -> new JwtException("변조된 토큰입니다"));

        String username = decodedJWT.getClaim("USERNAME").asString();
        String r = decodedJWT.getClaim("USER_ROLE").asString();
        int role = Integer.parseInt(r);

        return new MemberContext(username, "empty", role);
    }

    private Optional<DecodedJWT> isValidToken(String token) {
        DecodedJWT decodedJWT = null;

        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();

            decodedJWT = jwtVerifier.verify(token);
        } catch(UnsupportedEncodingException e) {
            log.error(e.getMessage());
        }
        return Optional.ofNullable(decodedJWT);
    }
}
