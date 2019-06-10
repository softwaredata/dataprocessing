package net.skhu.config.security.provider;

import net.skhu.config.security.MemberContext;
import net.skhu.config.security.token.PostAuthorizationToken;
import net.skhu.config.security.token.PreAuthorizationToken;
import net.skhu.domain.Member;
import net.skhu.exception.LoginException;
import net.skhu.mapper.UserMapper;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * Created by bomi on 2019-06-10.
 */

@Component
public class LoginRequestProvider implements AuthenticationProvider {

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public LoginRequestProvider(final UserMapper userMapper, final PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        PreAuthorizationToken preAuthorizationToken = (PreAuthorizationToken)authentication;

        Optional<String> username = Optional.ofNullable((String)preAuthorizationToken.getPrincipal());
        Optional<String> password = Optional.ofNullable((String)preAuthorizationToken.getCredentials());

        if(!username.isPresent()) {
            throw new LoginException("존재하지 않는 사용자입니다");
        }

        if(!password.isPresent()) {
            throw new LoginException("패스워드를 입력하세요");
        }

        int idx = Integer.parseInt(username.get());
        Optional<Member> member = Optional.ofNullable(userMapper.findByStuId(idx));
        if(!member.isPresent()) {
            throw new LoginException("존재하지 않는 사용자 입니다");
        }

        int type = member.get().getType();

        if(passwordEncoder.matches(password.get(), member.get().getPassword())) {
            return PostAuthorizationToken.getPostAuthorizationToken(MemberContext.getMemberContext(member.get(), type));
        }
        throw new LoginException("패스워드가 일치하지 않습니다");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return PreAuthorizationToken.class.isAssignableFrom(authentication);
    }
}
