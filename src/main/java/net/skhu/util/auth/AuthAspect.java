package net.skhu.util.auth;

import lombok.extern.slf4j.Slf4j;
import net.skhu.config.jwt.JwtDecoder;
import net.skhu.config.jwt.JwtDecoderTest;
import net.skhu.config.jwt.JwtFactory;
import net.skhu.config.jwt.token.Token;
import net.skhu.domain.Member;
import net.skhu.exception.JwtException;
import net.skhu.mapper.MemberMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bomi on 2019-06-20.
 */

@Slf4j
@Component
@Aspect
public class AuthAspect {

    private final static String AUTHORIZATION = "Authorization";

    private final HttpServletRequest httpServletRequest;

    private final MemberMapper memberMapper;

    private final JwtDecoderTest jwtDecoder;

    public AuthAspect(final HttpServletRequest httpServletRequest,
                      final MemberMapper memberMapper,
                      final JwtDecoderTest jwtDecoder) {
        this.httpServletRequest = httpServletRequest;
        this.memberMapper = memberMapper;
        this.jwtDecoder = jwtDecoder;
    }

    @Around("@annotation(net.skhu.util.auth.Auth)")
    public Object around(final ProceedingJoinPoint pjp) throws Throwable {
        final String jwt = httpServletRequest.getHeader(AUTHORIZATION);

        if(jwt == null) {
            throw new JwtException("authorization 검사 결과 없음");
        }

        final Token token = jwtDecoder.decode(jwt);

        if(StringUtils.isEmpty(token.getUserName())) {
            throw new JwtException("token 검사 결과 없음");
        }

        final int userNumber = Integer.parseInt(token.getUserName());
        final Member member = memberMapper.findByStuId(userNumber);

        //유효 사용자 검사
        if(member == null) {
            throw new JwtException("토큰 결과: 없는 유저");
        }

        return pjp.proceed(pjp.getArgs());
    }

}

