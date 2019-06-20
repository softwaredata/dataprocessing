package net.skhu.config.security.provider;

import lombok.extern.slf4j.Slf4j;
import net.skhu.config.security.MemberContext;
import net.skhu.config.security.token.PostAuthorizationToken;
import net.skhu.config.security.token.PreAuthorizationToken;
import net.skhu.domain.Member;
import net.skhu.exception.LoginException;
import net.skhu.mapper.MemberMapper;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Created by bomi on 2019-06-10.
 */

@Slf4j
@Component
public class LoginRequestProvider implements AuthenticationProvider {

    private final MemberMapper memberMapper;

    private final PasswordEncoder passwordEncoder;

    public LoginRequestProvider(final MemberMapper memberMapper, final PasswordEncoder passwordEncoder) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        PreAuthorizationToken preAuthorizationToken = (PreAuthorizationToken)authentication;

        Optional<String> username = Optional.ofNullable((String)preAuthorizationToken.getPrincipal());
        Optional<String> password = Optional.ofNullable((String)preAuthorizationToken.getCredentials());

        log.info(username.get());
        log.info(password.get());

        log.info(passwordEncoder.encode("1234"));

        if(!username.isPresent()) {
            throw new LoginException("존재하지 않는 사용자입니다");
        }

        if(!password.isPresent()) {
            throw new LoginException("패스워드를 입력하세요");
        }

        int idx = Integer.parseInt(username.get());
        Optional<Member> member = Optional.ofNullable(memberMapper.findByStuId(idx));
        if(!member.isPresent()) {
            throw new LoginException("존재하지 않는 사용자 입니다");
        }

        if(passwordEncoder.matches(password.get(), member.get().getPassword())) {
            int type = member.get().getType();

            return PostAuthorizationToken.getPostAuthorizationToken(MemberContext.getMemberContext(member.get(), type));
        }
        throw new LoginException("패스워드가 일치하지 않습니다");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return PreAuthorizationToken.class.isAssignableFrom(authentication);
    }
}
