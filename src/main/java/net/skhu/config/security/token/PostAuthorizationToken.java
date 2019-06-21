package net.skhu.config.security.token;

import net.skhu.config.security.MemberContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by bomi on 2019-06-10.
 */
public class PostAuthorizationToken extends UsernamePasswordAuthenticationToken {
    public PostAuthorizationToken(PreAuthorizationToken token) {
        this(token.getPrincipal(), token.getCredentials(), null);
    }

    public PostAuthorizationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public static PostAuthorizationToken getPostAuthorizationToken(MemberContext memberContext) {
        return new PostAuthorizationToken(memberContext, memberContext.getPassword(), memberContext.getAuthorities());
    }
}
