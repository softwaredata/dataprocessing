package net.skhu.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Member;
import net.skhu.dto.PwsReq;
import net.skhu.email.Email;
import net.skhu.mapper.MemberMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Slf4j
@Service
@RequiredArgsConstructor
public class PwsService {

    private final PasswordEncoder passwordEncoder;

    private final MemberMapper memberMapper;

    private final EmailService emailService;

    public void find_psw(HttpServletResponse response,PwsReq pwsReq) throws Exception{

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        if(pwsReq == null) {
            out.print("입력");
            out.close();
            return;
        }

        Member member= Member.builder()
                .studentIdx(pwsReq.getId())
                .email(pwsReq.getEmail())
                .build();

        // 아이디가 없으면
        if(memberMapper.findUser(member.getStudentIdx())==0) {
            out.print("존재하지 않는 아이디 입니다.");
            out.close();
        }

        // 가입한 아이디에 이메일이 아니면
        else if(memberMapper.findUserMatchEmail(member) ==0) {
            out.print("가입한 아이디와 이메일이 일치하지않습니다.");
            out.close();
        }

        else{// 임시 비밀번호 생성
            StringBuilder pw = new StringBuilder();
            for (int i = 0; i < 12; i++) {
                pw.append((char) ((Math.random() * 26) + 97));
            }

            //비밀번호인코딩
            member.setPassword(passwordEncoder.encode(pw.toString()));
            //비밀번호 변경
            memberMapper.updatePws(member);

            // 비밀번호 변경 메일 발송
            send_email(member, pw.toString());
            out.print("입력하신 이메일로 임시 비밀번호를 발송하였습니다.");
            out.close();
        }
    }

    public void send_email(Member member, String pw) throws MessagingException {

        String sender = "dont_reply";
        String recipient = member.getEmail();
        String subject = "SKHU VOTE(성공회대 투표 시스템) 임시 비밀번호 입니다. 재발신 하지 마세요!";
        String content = "";

        content += member.getStudentIdx() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.";
        content += "임시 비밀번호 : " + pw;

        Email email = Email.builder()
                .sender(sender)
                .recipient(recipient)
                .subject(subject)
                .content(content)
                .build();

        emailService.sendMail(email);
    }

}
