package net.skhu.config.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.skhu.config.jwt.JwtFactory;
import net.skhu.config.security.MemberContext;
import net.skhu.config.security.token.PostAuthorizationToken;
import net.skhu.dto.LoginRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bomi on 2019-06-10.
 */

@Component
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtFactory jwtFactory;

    //private final ObjectMapper objectMapper;

    public LoginAuthenticationSuccessHandler(final JwtFactory jwtFactory, final ObjectMapper objectMapper) {
        this.jwtFactory = jwtFactory;
        //this.objectMapper = objectMapper;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        PostAuthorizationToken token = (PostAuthorizationToken)authentication;

        MemberContext memberContext = (MemberContext)token.getPrincipal();

        String tokenString = jwtFactory.create(memberContext);


    }
}
