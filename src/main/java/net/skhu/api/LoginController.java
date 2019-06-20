package net.skhu.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Member;
import net.skhu.dto.LoginRequest;
import net.skhu.mapper.MemberMapper;
import net.skhu.service.LoginService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public String loginProcessing(LoginRequest loginRequest, Model model) {
        System.out.println(loginRequest.getIdx());
        System.out.println(loginRequest.getPassword());
        Member member = memberMapper.findByIdAndPassword(loginRequest.getIdx(), loginRequest.getPassword());
        if(member == null) return "redirect:login-error";
        model.addAttribute("member", member);
        return "redirect:main";
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

