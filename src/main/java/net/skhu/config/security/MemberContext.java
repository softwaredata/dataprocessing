package net.skhu.config.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.*;

/**
 * Created by bomi on 2019-05-14.
 */
public class MemberContext extends User {
    public MemberContext(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public MemberContext(String name, String password, String roles) {
        super(name, password, parseAuthorities(roles));
    }

    private static List<SimpleGrantedAuthority> parseAuthorities(String roles) {
        String[] arr = roles.split(",");
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(String role : arr) {
            list.add(new SimpleGrantedAuthority(role));
        }
        return list;
    }
}
