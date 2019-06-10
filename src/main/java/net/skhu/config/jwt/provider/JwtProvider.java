package net.skhu.config.jwt.provider;


import lombok.extern.slf4j.Slf4j;
import net.skhu.config.jwt.JwtDecoder;
import net.skhu.config.jwt.token.JwtPreProcessingToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created by bomi on 2019-05-14.
 */

@Slf4j
@Component
public class JwtProvider implements AuthenticationProvider {

    private final JwtDecoder jwtDecoder;

    public JwtProvider(JwtDecoder jwtDecoder) {
        this.jwtDecoder = jwtDecoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = (String)authentication.getPrincipal();

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtPreProcessingToken.class.isAssignableFrom(authentication);
    }
}
