package net.skhu.config.jwt.handler;

import lombok.extern.slf4j.Slf4j;
import net.skhu.exception.JwtException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bomi on 2019-06-10.
 */

@Component
@Slf4j
public class JwtAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.error(exception.getMessage());
        throw new JwtException(exception.getMessage());
    }
}
