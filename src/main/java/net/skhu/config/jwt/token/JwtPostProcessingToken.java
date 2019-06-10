package net.skhu.config.jwt.token;

import net.skhu.config.security.MemberContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by bomi on 2019-06-10.
 */
public class JwtPostProcessingToken extends UsernamePasswordAuthenticationToken {

    public static JwtPostProcessingToken getJwtPostProcessingToken(MemberContext memberContext) {
        return new JwtPostProcessingToken(memberContext.getMember().getName()
                , memberContext.getMember().getPassword()
                , memberContext.getAuthorities());
    }

    public JwtPostProcessingToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
