package net.skhu.config.security;

import net.skhu.domain.Member;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.*;

/**
 * Created by bomi on 2019-05-14.
 */
@Getter
public class MemberContext extends User {

    private Member member;

    public MemberContext(Member member, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.member = member;
    }

    public MemberContext(String name, String password, int role) {
        super(name, password, parseAuthorities(role));
    }

    public static MemberContext getMemberContext(Member member, int roles) {
        return new MemberContext(member, String.valueOf(member.getStudentIdx()), member.getPassword(), parseAuthorities(roles));
    }

    private static List<SimpleGrantedAuthority> parseAuthorities(int roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        String role = "";
        if(roles == 0) {
            role = "ROLE_USER";
        } else if(roles == 1) {
            role = "ROLE_ADMIN";
        }
        list.add(new SimpleGrantedAuthority(role));
        return list;
    }

//    private static List<SimpleGrantedAuthority> parseAuthorities(List roles) {
//        List<SimpleGrantedAuthority> list = new ArrayList<>();
//        for(role : roles) {
//            list.add(new SimpleGrantedAuthority(role.get));
//        }
//        return
//    }

    public Member getMember() {
        return this.member;
    }
}
