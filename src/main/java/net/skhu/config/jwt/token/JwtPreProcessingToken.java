package net.skhu.config.jwt.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Created by bomi on 2019-05-14.
 */
public class JwtPreProcessingToken extends UsernamePasswordAuthenticationToken {

    private JwtPreProcessingToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public JwtPreProcessingToken(String token) {
        this(token, null);
    }
}
