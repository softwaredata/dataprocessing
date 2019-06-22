package net.skhu.api;

import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Member;
import net.skhu.dto.LoginRequest;
import net.skhu.dto.SignUpRequest;
import net.skhu.mapper.MemberMapper;
import net.skhu.service.LoginService;
import net.skhu.service.SignUpService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by bomi on 2019-05-03.
 */

@Slf4j
@Controller
@RequestMapping("/")
public class LoginController {

    private final LoginService loginService;
    private final MemberMapper memberMapper;

    private final SignUpService signUpService;

    private final PasswordEncoder passwordEncoder;

    public LoginController(final LoginService loginService, MemberMapper memberMapper, SignUpService signUpService, PasswordEncoder passwordEncoder) {
        this.loginService = loginService;
        this.memberMapper = memberMapper;
        this.signUpService = signUpService;
        this.passwordEncoder = passwordEncoder;
    }

//    @PostMapping("login")
//    public String login(@RequestBody(required = false) LoginRequest loginReq) {
//        log.info("come");
//        log.info(loginReq.toString());
//        loginService.login(loginReq);
//        return "main/main";
//}

    @PostMapping("login-processing")

    public String loginProcessing(@RequestParam("id")String id, @RequestParam("password")String pw, Model model, HttpServletResponse response
                                ,HttpSession session) throws IOException {

        System.out.println(id);
        System.out.println(pw);
        LoginRequest loginRequest = new LoginRequest(id, pw);

        Member member = loginService.login(loginRequest, response);
        model.addAttribute("member", member);

        session.setAttribute("user", member);


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


    @GetMapping("signUp")
    public String signUpGo() {
        return "users/signUp";
    }

    @PostMapping("signUp")
    public String memberInsert(
            @RequestParam("studentIdx") Integer studentIdx,
            @RequestParam("password1") String password1,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("department") String department){

        SignUpRequest signUpRequest = SignUpRequest.builder()
                .studentIdx(studentIdx)
                .password1(password1)
                .name(name)
                .email(email)
                .department(department)
                .type(0)
                .build();

        signUpService.signUp(signUpRequest);
        return "redirect:login";
    }


    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";
    }

}

