package net.skhu.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.PwsReq;
import net.skhu.mapper.UserMapper;
import net.skhu.domain.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PwsService {

    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    public void find_pw(Users users) throws Exception {

        // 아이디가 없으면
        if(userMapper.findUser(users.getStudentIdx())==0)
            System.out.println("일치아이디 없음");
        // 가입에 사용한 이메일이 아니면
        else if(userMapper.findUserMatchEmail(users) ==0)
            System.out.println("이메일 일치하지않음");
        else{// 임시 비밀번호 생성
            String pw = "";
            for (int i = 0; i < 12; i++) {
                pw += (char) ((Math.random() * 26) + 97);
            }
            //비밀번호인코딩
            users.setPassword(passwordEncoder.encode(pw));
            // 비밀번호 변경
            userMapper.updatePws(users);
        }

        // 비밀번호 변경 메일 발송
        //send_mail(users, "find_pw");

        //out.print("이메일로 임시 비밀번호를 발송하였습니다.");
        //out.close();

    }

//    // 이메일 발송
//    public void send_mail(Users users, String div) throws Exception {
//        // Mail Server 설정
//        String charSet = "utf-8";
//        String hostSMTP = "smtp.naver.com";
//        String hostSMTPid = "이메일 입력";
//        String hostSMTPpwd = "비밀번호 입력";
//
//        // 보내는 사람 EMail, 제목, 내용
//        String fromEmail = "이메일 입력";
//        String fromName = "Spring Homepage";
//        String subject = "";
//        String msg = "";
//
//        if(div.equals("find_pw")) {
//            subject = "Spring Homepage 임시 비밀번호 입니다.";
//            msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
//            msg += "<h3 style='color: blue;'>";
//            msg += users.getStudentIdx() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
//            msg += "<p>임시 비밀번호 : ";
//            msg += users.getPassword() + "</p></div>";
//        }
//        // 받는 사람 E-Mail 주소
//        String mail = users.getEmail();
//        try {
//            HtmlEmail email = new HtmlEmail();
//            email.setDebug(true);
//            email.setCharset(charSet);
//            email.setSSL(true);
//            email.setHostName(hostSMTP);
//            email.setSmtpPort(587);
//
//            email.setAuthentication(hostSMTPid, hostSMTPpwd);
//            email.setTLS(true);
//            email.addTo(mail, charSet);
//            email.setFrom(fromEmail, fromName, charSet);
//            email.setSubject(subject);
//            email.setHtmlMsg(msg);
//            email.send();
//        } catch (Exception e) {
//            System.out.println("메일발송 실패 : " + e);
//        }
//    }

}
