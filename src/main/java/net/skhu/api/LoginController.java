package net.skhu.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Member;
import net.skhu.dto.LoginRequest;
import net.skhu.exception.LoginException;
import net.skhu.mapper.MemberMapper;
import net.skhu.service.LoginService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by bomi on 2019-05-03.
 */

@Slf4j
@Controller
@RequestMapping("/")
public class LoginController {
    private final LoginService loginService;
    private final MemberMapper memberMapper;

    public LoginController(final LoginService loginService, MemberMapper memberMapper) {
        this.loginService = loginService;
        this.memberMapper = memberMapper;
    }

//    @PostMapping("login")
//    public String login(@RequestBody(required = false) LoginRequest loginReq) {
//        log.info("come");
//        log.info(loginReq.toString());
//        loginService.login(loginReq);
//        return "main/main";
//}

    @PostMapping("login-processing")
    public String loginProcessing(@RequestParam("id")String id, @RequestParam("password")String pw, Model model, HttpServletResponse response) throws IOException {
        System.out.println(id);
        System.out.println(pw);
        LoginRequest loginRequest = new LoginRequest(id, pw);

        Member member = loginService.login(loginRequest, response);
        model.addAttribute("member", member);

        return "main/main";
    }


    @GetMapping({"", "login"})
    public String login(Model model, HttpServletRequest request) {
        log.info("get");
        request.setAttribute("error", "");
        model.addAttribute("loginError", false);
        model.addAttribute("findError", false);
        return "login";
    }

    //로그인 실패
    @GetMapping(value = "login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("findError", false);
        return "login";
    }

    @PostMapping("login-error")
    public String loginError() {
        return "login";
    }

}

