package net.skhu.config.security.token;

import net.skhu.dto.LoginRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by bomi on 2019-06-10.
 */
public class PreAuthorizationToken extends UsernamePasswordAuthenticationToken {
    public PreAuthorizationToken(String principal, String credentials) {
        super(principal, credentials);
    }

    public PreAuthorizationToken(LoginRequest loginRequest) {
        super(loginRequest.getId(), loginRequest.getPassword());
    }
}
