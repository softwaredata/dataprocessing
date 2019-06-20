package net.skhu.service;

import lombok.extern.slf4j.Slf4j;
import net.skhu.config.jwt.JwtFactory;
import net.skhu.config.jwt.TokenRes;
import net.skhu.domain.Member;
import net.skhu.dto.LoginRequest;
import net.skhu.exception.LoginException;
import net.skhu.mapper.MemberMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by bomi on 2019-05-03.
 */
@Slf4j
@Service
public class LoginService {
    private final MemberMapper memberMapper;

    private final PasswordEncoder passwordEncoder;

    public LoginService(final MemberMapper memberMapper, final PasswordEncoder passwordEncoder) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public TokenRes login(final LoginRequest loginRequest) {
        if(loginRequest == null) throw new LoginException("no");
        final Member member = memberMapper.findByIdAndPassword(loginRequest.getIdx(),
                passwordEncoder.encode(loginRequest.getPassword()));

        if(member == null) {
            throw new LoginException("일치하는 유저 없음");
        }

        final TokenRes token = new TokenRes(JwtFactory.create(member));

        return token;
    }
}
