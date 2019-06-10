package net.skhu.config.jwt.filters;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bomi on 2019-05-14.
 */
public class JwtRequestMatcher implements RequestMatcher {
    private OrRequestMatcher orRequestMatcher;
    private RequestMatcher processingMatcher;

    public JwtRequestMatcher(List<String> path, String processingPath) {
        this.orRequestMatcher = new OrRequestMatcher(path.stream()
                                                            .map(p -> new AntPathRequestMatcher(p))
                                                            .collect(Collectors.toList()));
        this.processingMatcher = new AntPathRequestMatcher(processingPath);
    }


    @Override
    public boolean matches(HttpServletRequest request) {
        return !orRequestMatcher.matches(request) && processingMatcher.matches(request);
    }
}
