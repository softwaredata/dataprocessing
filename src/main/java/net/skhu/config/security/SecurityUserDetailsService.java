package net.skhu.config.security;

import net.skhu.domain.Member;
import net.skhu.exception.LoginException;
import net.skhu.mapper.MemberMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by bomi on 2019-06-21.
 */

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final MemberMapper memberMapper;

    public SecurityUserDetailsService(final MemberMapper memeberMapper) {
        this.memberMapper = memeberMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException  {
        System.out.println("userdetail      "  + id);
        Member member = null;
        try {
            int idx = Integer.parseInt(id);
            member = memberMapper.findByStuId(idx);
        } catch(NumberFormatException e) {
            throw new LoginException("login fail");
        }

        //System.out.println(member.getStudentIdx());
        if(member == null) {
            throw new UsernameNotFoundException("login fail");
        }
        if(member.getType() == 0) {
            return new SecurityUserDetails(member, "ROLE_USER");
        }
        return new SecurityUserDetails(member, "ROLE_ADMIN");
    }
}
