package net.skhu.config.security.handler;

import net.skhu.domain.Member;
import net.skhu.exception.LoginException;
import net.skhu.mapper.MemberMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bomi on 2019-06-10.
 */

//@Component
public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final MemberMapper memberMapper;

    public LoginAuthenticationFailureHandler(final MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        final String id = request.getParameter("id");
        final String pw = request.getParameter("password");

        int memberNumber = 0;
        if(!StringUtils.isEmpty(id)) {
            memberNumber = Integer.parseInt(id);
        }

        Member member = memberMapper.findByStuId(memberNumber);

        if(member == null) {
            request.setAttribute("error", new LoginException("등록된 사용자 아님"));
            request.getRequestDispatcher("/login-error").forward(request, response);
        } else {
            if(!member.getPassword().equals(pw)) {
                request.setAttribute("error", new LoginException("아이디 또는 비밀번호가 잘못되었습니다"));
                request.getRequestDispatcher("/login-error").forward(request, response);
            }
        }

    }
}