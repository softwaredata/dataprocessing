package net.skhu.config.security;

import net.skhu.domain.Member;
import net.skhu.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by bomi on 2019-06-21.
 */

//@Service
public class SecurityAdminDetailsService implements UserDetailsService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException  {
        System.out.println("userdetail      "  + id);
        int idx = Integer.parseInt(id);
        System.out.println(idx);
        Member member = memberMapper.findByStuId(idx);
        //System.out.println(member.getStudentIdx());
        if(member == null)
            throw new UsernameNotFoundException("login fail");
        return new SecurityAdminDetails(member);
    }
}
