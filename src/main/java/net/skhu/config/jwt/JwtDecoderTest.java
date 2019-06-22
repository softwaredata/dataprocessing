package net.skhu.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import net.skhu.config.jwt.token.Token;
import net.skhu.config.security.MemberContext;
import net.skhu.exception.JwtException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import static com.auth0.jwt.JWT.require;

/**
 * Created by bomi on 2019-05-14.
 */

@Component
@Slf4j
public class JwtDecoderTest {
    @Value("${JWT.SECRET}")
    private static String SECRET;

    public Token decode(String token) {
        try {
            //final JWTVerifier jwtVerifier = require(Algorithm.HMAC256(SECRET)).withIssuer(ISSUER).build();
            DecodedJWT decodedJWT = isValidToken(token).orElseThrow(() -> new JwtException("변조된 토큰입니다"));

            String username = decodedJWT.getClaim("USERNAME").asString();
            String role = decodedJWT.getClaim("USERROLE").asString();

            return new Token(username, role);
        } catch (JWTVerificationException jve) {
            log.error(jve.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new Token();
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
