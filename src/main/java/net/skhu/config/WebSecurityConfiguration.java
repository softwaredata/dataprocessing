package net.skhu.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.skhu.config.jwt.filters.JwtFilter;
import net.skhu.config.jwt.filters.JwtRequestMatcher;
import net.skhu.config.jwt.handler.JwtAuthenticationFailureHandler;
import net.skhu.config.jwt.provider.JwtProvider;
import net.skhu.config.security.SecurityAdminDetailsService;
import net.skhu.config.security.filter.CustomFilterInvocationSecurityMetadataSource;
import net.skhu.config.security.filter.CustomVote;
import net.skhu.config.security.filter.LoginRequestFilter;
import net.skhu.config.security.handler.LoginAuthenticationFailureHandler;
import net.skhu.config.security.handler.LoginAuthenticationSuccessHandler;
import net.skhu.config.security.provider.LoginRequestProvider;
import net.skhu.dto.LoginRequest;
import net.skhu.util.auth.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    //
//    @Bean
//    public ObjectMapper getObjectMapper() {
//        return new ObjectMapper();
//    }
//
    @Bean
    public AuthenticationManager getAuthenticationManger() throws Exception {
        return super.authenticationManagerBean();
    }

    //
//    private final LoginAuthenticationSuccessHandler loginAuthenticationSuccessHandler;
//    private final LoginAuthenticationFailureHandler loginAuthenticationFailureHandler;
//
//    private final LoginRequestProvider loginRequestProvider;
//
//    private final JwtAuthenticationFailureHandler jwtAuthenticationFailureHandler;
//
//    private final JwtProvider jwtProvider;
//
//    public WebSecurityConfiguration(final LoginAuthenticationSuccessHandler loginAuthenticationSuccessHandler,
//                                    final LoginAuthenticationFailureHandler loginAuthenticationFailureHandler,
//                                    final LoginRequestProvider loginRequestProvider,
//                                    final JwtAuthenticationFailureHandler jwtAuthenticationFailureHandler,
//                                    final JwtProvider jwtProvider) {
//        this.loginAuthenticationSuccessHandler = loginAuthenticationSuccessHandler;
//        this.loginAuthenticationFailureHandler = loginAuthenticationFailureHandler;
//        this.loginRequestProvider = loginRequestProvider;
//        this.jwtAuthenticationFailureHandler = jwtAuthenticationFailureHandler;
//        this.jwtProvider = jwtProvider;
//    }
//
    protected LoginRequestFilter getLoginRequestFilter() throws Exception {
        LoginRequestFilter loginRequestFilter = new LoginRequestFilter("/login-processing", loginAuthenticationSuccessHandler, loginAuthenticationFailureHandler);
        loginRequestFilter.setAuthenticationManager(super.authenticationManagerBean());
        return loginRequestFilter;
    }
//
//    protected JwtFilter getJwtFilter() throws Exception {
//        JwtRequestMatcher jwtRequestMatcher = new JwtRequestMatcher(Arrays.asList("/login-processing"), "/**");
//        JwtFilter jwtFilter = new JwtFilter(jwtRequestMatcher, jwtAuthenticationFailureHandler);
//        jwtFilter.setAuthenticationManager(super.authenticationManagerBean());
//
//        return jwtFilter;
//    }
//
//    @Bean
//    public AccessDecisionManager accessDecisionManager() {
//        List<AccessDecisionVoter<? extends Object>> decisionVoters = Arrays.asList(
//                new CustomVote());
//        return new UnanimousBased(decisionVoters);
//    }
//
//    @Bean
//    protected FilterSecurityInterceptor getFilterInvocationSecurityMetadataSource() throws Exception {
//        FilterSecurityInterceptor filterSecurityInterceptor = new FilterSecurityInterceptor();
//        filterSecurityInterceptor.setAuthenticationManager(super.authenticationManagerBean());
//        filterSecurityInterceptor.setSecurityMetadataSource(new CustomFilterInvocationSecurityMetadataSource());
//        filterSecurityInterceptor.setAccessDecisionManager(accessDecisionManager());
//        return filterSecurityInterceptor;
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder
//                .authenticationProvider(this.loginRequestProvider);
//    }

    private final LoginAuthenticationFailureHandler loginAuthenticationFailureHandler;
    private final LoginAuthenticationSuccessHandler loginAuthenticationSuccessHandler;

    private final LoginRequestProvider loginRequestProvider;

    public WebSecurityConfiguration(final LoginAuthenticationFailureHandler loginAuthenticationFailureHandler,
                                    final LoginAuthenticationSuccessHandler loginAuthenticationSuccessHandler,
                                    final LoginRequestProvider loginRequestProvider) {
        this.loginAuthenticationFailureHandler = loginAuthenticationFailureHandler;
        this.loginAuthenticationSuccessHandler = loginAuthenticationSuccessHandler;
        this.loginRequestProvider = loginRequestProvider;
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//        http.authorizeRequests()
//                .antMatchers("/", "/login", "/login-error", "/findPws", "/api/v1/signUp", "/mypage").permitAll()
//                .antMatchers("/**").authenticated();

        http.csrf().disable();

//        http.formLogin()
//                .loginPage("/")
//                .loginPage("/login")
//                .permitAll()
//                //.failureHandler(loginAuthenticationFailureHandler)
//                //.successHandler(loginAuthenticationSuccessHandler)
//                .successForwardUrl("/main")
//                .loginProcessingUrl("/login-processing")
//                .failureUrl("/login-error")
//                .usernameParameter("id")
//                .passwordParameter("password");

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                //.logoutSuccessHandler(customizeLogoutService)
                .invalidateHttpSession(true);

       // http.authenticationProvider(loginRequestProvider);

        http
                .headers()
                .frameOptions().sameOrigin()
                .httpStrictTransportSecurity().disable();//security가 iframe을 방어하는걸 제거
//
//        http.csrf().disable().authorizeRequests()
//                //.antMatchers("/api/v1/**","/home", "/login", "/","/**").permitAll()
//                .antMatchers("/login").permitAll()
//                .anyRequest().authenticated();
//
//        http
//                .formLogin()
//                .loginPage("/")
//                .loginPage("/login")
//                .loginProcessingUrl("/login-processing")
//                .failureForwardUrl("/login")
//                .defaultSuccessUrl("/main", true)
//                .usernameParameter("id")
//                .passwordParameter("password")
//                .and()
//
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/")
//                .invalidateHttpSession(true);
//
//        http
//                .addFilterBefore(getLoginRequestFilter(), UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(getJwtFilter(), UsernamePasswordAuthenticationFilter.class)
//                .addFilterAfter(getFilterInvocationSecurityMetadataSource(), FilterSecurityInterceptor.class);
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        System.out.println("들어온다");

        return new InMemoryUserDetailsManager(user);
    }

    @Configuration
    public static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

        @Autowired
        SecurityAdminDetailsService adminDetailsService;

        @Autowired
        PasswordEncoder passwordEncoder;

//        @Bean
//        PasswordEncoder passwordEncoder() {
//            return new PasswordEncoder();
//        }

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(adminDetailsService).passwordEncoder(passwordEncoder);
        }
    }
}

