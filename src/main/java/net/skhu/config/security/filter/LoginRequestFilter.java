package net.skhu.config.security.filter;

import net.skhu.config.security.token.PreAuthorizationToken;
import net.skhu.dto.LoginRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bomi on 2019-06-10.
 */
public class LoginRequestFilter extends AbstractAuthenticationProcessingFilter {

    private AuthenticationSuccessHandler authenticationSuccessHandler;
    private AuthenticationFailureHandler authenticationFailureHandler;

    private LoginRequestFilter(String defaultFilterProcessUrl) {
        super(defaultFilterProcessUrl);
    }

    public LoginRequestFilter(String defaultUrl, AuthenticationSuccessHandler authenticationSuccessHandler, AuthenticationFailureHandler authenticationFailureHandler) {
        this(defaultUrl);
        this.authenticationSuccessHandler = authenticationSuccessHandler;
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        //LoginRequest loginRequest = new ObjectMapper().readValue(request.getReader(), LoginRequest.class);
        String id = request.getParameter("id");
        String pw = request.getParameter("password");

        PreAuthorizationToken token = new PreAuthorizationToken(new LoginRequest(id, pw));
        return super.getAuthenticationManager().authenticate(token);
    }

    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authResult) throws IOException, ServletException {
        this.authenticationSuccessHandler.onAuthenticationSuccess(request, response, authResult);
    }

    @Override
    public void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        this.authenticationFailureHandler.onAuthenticationFailure(request, response, exception);
    }
}