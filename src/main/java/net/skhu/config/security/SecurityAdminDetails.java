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

    public SecurityAdminDetails(Member member) {
        super(
                String.valueOf(member.getStudentIdx()),
                member.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_ADMIN")
        );
        id = member.getStudentIdx();
    }
}
