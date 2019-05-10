package net.skhu.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

        // 가입에 사용한 이메일이 아니면

        // 임시 비밀번호 생성
        String pw = "";
        for (int i = 0; i < 12; i++) {
            pw += (char) ((Math.random() * 26) + 97);
        }
        //users.setPassword(pw);
        // 비밀번호 변경
        userMapper.updatePws(users);
        // 비밀번호 변경 메일 발송
        //send_mail(users, "find_pw");

        //out.print("이메일로 임시 비밀번호를 발송하였습니다.");
        //out.close();

    }

}
