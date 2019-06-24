package net.skhu.domain;

import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by bomi on 2019-06-22.
 */
public class SecurityUser extends User {

    @Getter
    private Member member;

    public SecurityUser(Member member) {
        super(String.valueOf(member.getStudentIdx()),
                member.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_MEMBER"));
        this.member = member;
    }
}
