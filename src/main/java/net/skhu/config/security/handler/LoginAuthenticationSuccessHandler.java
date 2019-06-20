package net.skhu.config.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.skhu.config.jwt.JwtFactory;
import net.skhu.config.security.MemberContext;
import net.skhu.config.security.token.PostAuthorizationToken;
import net.skhu.dto.LoginRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bomi on 2019-06-10.
 */

@Slf4j
@Component
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtFactory jwtFactory;

    //private final ObjectMapper objectMapper;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public LoginAuthenticationSuccessHandler(final JwtFactory jwtFactory, final ObjectMapper objectMapper) {
        this.jwtFactory = jwtFactory;
        //this.objectMapper = objectMapper;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("come");

        PostAuthorizationToken token = (PostAuthorizationToken)authentication;
        log.info(token.toString());
        MemberContext memberContext = (MemberContext)token.getPrincipal();
        log.info(memberContext.getUsername());
        log.info(memberContext.getPassword());
        String tokenString = jwtFactory.create(memberContext);
        log.info(tokenString);
        redirectStrategy.sendRedirect(request, response, "/main");
    }
}
