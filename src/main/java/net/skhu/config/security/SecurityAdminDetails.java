package net.skhu.config.security;

import lombok.Getter;
import net.skhu.domain.Member;
import org.apache.ibatis.ognl.MemberAccess;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by bomi on 2019-06-21.
 */
public class SecurityAdminDetails extends User {
    private static final long serialVersionUID = 1L;

    @Getter
    int id;

    @Getter
    Member member;

    public SecurityAdminDetails(Member member, String authority) {

        super(
                String.valueOf(member.getStudentIdx()),
                member.getPassword(),
                AuthorityUtils.createAuthorityList(authority)
        );

        id = member.getStudentIdx();
        this.member = member;
    }
}
