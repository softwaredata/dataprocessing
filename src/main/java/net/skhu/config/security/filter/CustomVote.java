package net.skhu.config.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by bomi on 2019-06-19.
 */

@Slf4j
public class CustomVote implements AccessDecisionVoter {
    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, Object object, Collection collection) {
        List<SecurityConfig> securityConfigs = (List<SecurityConfig>)collection;
        List<GrantedAuthority> urlRole = AuthorityUtils.commaSeparatedStringToAuthorityList(securityConfigs.toString());

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<GrantedAuthority> userRole = new ArrayList<>(authorities);

        boolean access = false;
        for(GrantedAuthority url : urlRole) {
            for(GrantedAuthority user : userRole) {
                log.info(url.toString());
                log.info(user.toString());
                if(url.toString().equals(user.toString())) {
                    access = true;
                }
            }
        }
        return access ? ACCESS_GRANTED : ACCESS_ABSTAIN;
    }

    @Override
    public boolean supports(Class clazz) {
        return true;
    }
}
