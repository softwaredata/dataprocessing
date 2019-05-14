package net.skhu.config.jwt.filters;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;
import net.skhu.config.jwt.token.JwtPreProcessingToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bomi on 2019-05-14.
 */
@Slf4j
public class JwtFilter extends AbstractAuthenticationProcessingFilter {
    //public JwtFilter(RequestMatcher matcher, JwtAuthenticationFailureHandler ) {};

    @Value("${jwt.secret}")
    private static String PREFIX;

    public JwtFilter(RequestMatcher matcher) {
        super(matcher);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        String token = httpServletRequest.getHeader("Authorization");
        token = tokenToHeaderValidation(token);
        JwtPreProcessingToken jwtPreProcessingToken = new JwtPreProcessingToken(token);
        return super.getAuthenticationManager().authenticate(jwtPreProcessingToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);
        chain.doFilter(request, response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        SecurityContextHolder.clearContext();
        this.unsuccessfulAuthentication(request, response, failed);
    }

    private String tokenToHeaderValidation(String header) {
        if(StringUtils.isEmpty(header) || header.length() < PREFIX.length()) {
            throw new JWTVerificationException("JWT 헤더 정보 에러");
        }
        return header.substring(PREFIX.length());
    }
}
