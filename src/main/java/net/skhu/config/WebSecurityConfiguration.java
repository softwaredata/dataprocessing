//package net.skhu.config;
//
//import net.skhu.config.security.filter.LoginRequestFilter;
//import net.skhu.config.security.handler.LoginAuthenticationFailureHandler;
//import net.skhu.config.security.handler.LoginAuthenticationSuccessHandler;
//import net.skhu.config.security.provider.LoginRequestProvider;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
////@Configuration
////@EnableWebSecurity
////@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    private final LoginAuthenticationFailureHandler loginAuthenticationFailureHandler;
//    private final LoginAuthenticationSuccessHandler loginAuthenticationSuccessHandler;
//
//    private final LoginRequestProvider loginRequestProvider;
//
//    public WebSecurityConfiguration(final LoginAuthenticationFailureHandler loginAuthenticationFailureHandler,
//                                    final LoginAuthenticationSuccessHandler loginAuthenticationSuccessHandler,
//                                    final LoginRequestProvider loginRequestProvider) {
//        this.loginAuthenticationFailureHandler = loginAuthenticationFailureHandler;
//        this.loginAuthenticationSuccessHandler = loginAuthenticationSuccessHandler;
//        this.loginRequestProvider = loginRequestProvider;
//    }
//
////    private final LoginRequestProvider loginRequestProvider;
////
////    public WebSecurityConfiguration(final LoginRequestProvider loginRequestProvider) {
////        this.loginRequestProvider = loginRequestProvider;
////    }
//
////    protected LoginRequestFilter getLoginRequestFilter() throws Exception {
////        LoginRequestFilter loginRequestFilter = new LoginRequestFilter("/login-processing", loginAuthenticationSuccessHandler, loginAuthenticationFailureHandler);
////        loginRequestFilter.setAuthenticationManager(super.authenticationManagerBean());
////        return loginRequestFilter;
////    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers("/", "/login", "/login-error", "/findPws", "/api/v1/signUp").permitAll()
//                .antMatchers("/**").authenticated();
//
//        http.csrf().disable();
//
//        http.formLogin()
//                .loginPage("/")
//                .loginPage("/login")
//                .permitAll()
//                .failureHandler(loginAuthenticationFailureHandler)
//                .successHandler(loginAuthenticationSuccessHandler)
//                .defaultSuccessUrl("/main")
//                .loginProcessingUrl("/login-processing")
//                .failureUrl("/login-error")
//                .usernameParameter("id")
//                .passwordParameter("password");
//
//        http.logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/")
//                //.logoutSuccessHandler(customizeLogoutService)
//                .invalidateHttpSession(true);
//
//       // http.authenticationProvider(loginRequestProvider);
//
//        http
//                .headers()
//                .frameOptions().sameOrigin()
//                .httpStrictTransportSecurity().disable();//security가 iframe을 방어하는걸 제거
//
//        http
//                .addFilterBefore(getLoginRequestFilter(), UsernamePasswordAuthenticationFilter.class);
//        http
//                .authenticationProvider(loginRequestProvider);
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder
//                .authenticationProvider(this.loginRequestProvider);
//    }
//
////    @Bean
////    @Override
////    protected UserDetailsService userDetailsService() {
////        UserDetails user =
////                User.withDefaultPasswordEncoder()
////                        .username("user")
////                        .password("password")
////                        .roles("USER")
////                        .build();
////
////        System.out.println("들어온다");
////
////        return new InMemoryUserDetailsManager(user);
////    }
//
////    @Configuration
////    public static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
////
////        @Autowired
////        SecurityAdminDetailsService adminDetailsService;
////
////        @Override
////        public void init(AuthenticationManagerBuilder auth) throws Exception {
////            auth.userDetailsService(adminDetailsService).passwordEncoder(new PasswordEncoderConfig().passwordEncoder());
////        }
////    }
//}
//
