package net.skhu.config;

import net.skhu.config.security.SecurityUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

//    private final LoginAuthenticationFailureHandler loginAuthenticationFailureHandler;
//    private final LoginAuthenticationSuccessHandler loginAuthenticationSuccessHandler;
//
//    private final LoginRequestProvider loginRequestProvider;

//    public WebSecurityConfiguration(
////            final LoginAuthenticationFailureHandler loginAuthenticationFailureHandler,
////                                    final LoginAuthenticationSuccessHandler loginAuthenticationSuccessHandler,
//                                    final LoginRequestProvider loginRequestProvider) {
////        this.loginAuthenticationFailureHandler = loginAuthenticationFailureHandler;
////        this.loginAuthenticationSuccessHandler = loginAuthenticationSuccessHandler;
//        this.loginRequestProvider = loginRequestProvider;
//    }

//    @Bean
//    public HttpSessionEventPublisher httpSessionEventPublisher() {
//        return new HttpSessionEventPublisher();
//    }

//    public WebSecurityConfiguration(final LoginRequestProvider loginRequestProvider) {
//        this.loginRequestProvider = loginRequestProvider;
//    }
//    public LoginRequestFilter getLoginRequestFilter() throws Exception {
//        LoginRequestFilter loginRequestFilter = new LoginRequestFilter("/login-processing", loginAuthenticationSuccessHandler, loginAuthenticationFailureHandler);
//        loginRequestFilter.setAuthenticationManager(super.authenticationManagerBean());
//        return loginRequestFilter;
//    }


    private final SecurityUserDetailsService securityUserDetailsService;

    private final PasswordEncoder passwordEncoder;

    public WebSecurityConfiguration(final SecurityUserDetailsService securityUserDetailsService,
                                    final PasswordEncoder passwordEncoder) {
        this.securityUserDetailsService = securityUserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/", "/login", "/login-error", "/perform_login", "/findPws", "/signUp").permitAll()
                .antMatchers("/**").authenticated();

        http.csrf().disable();

        http.formLogin()
                .loginPage("/login")
                .permitAll()
//                .failureHandler(loginAuthenticationFailureHandler)
//                .successHandler(loginAuthenticationSuccessHandler)
                .defaultSuccessUrl("/main")
                .successForwardUrl("/main")
                .loginProcessingUrl("/perform_login")
                .failureUrl("/login-error")
                .usernameParameter("id")
                .passwordParameter("password");

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                //.logoutSuccessHandler(customizeLogoutService)
                .invalidateHttpSession(true);

//        http.sessionManagement()
//                //.expiredUrl("/sessionExpired.html")
//                .invalidSessionUrl("/invalidSession.html");

//        http.authenticationProvider(loginRequestProvider);

        http
                .headers()
                .frameOptions().sameOrigin()
                .httpStrictTransportSecurity().disable();//security가 iframe을 방어하는걸 제거

//        http
//               .addFilterBefore(getLoginRequestFilter(), UsernamePasswordAuthenticationFilter.class);
//        http
//                .authenticationProvider(loginRequestProvider);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder
//                .authenticationProvider(this.loginRequestProvider);
//
        authenticationManagerBuilder
                .userDetailsService(securityUserDetailsService)
                .passwordEncoder(passwordEncoder);

    }

}
