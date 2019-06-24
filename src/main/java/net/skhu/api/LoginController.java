package net.skhu.api;

import com.sun.javafx.collections.MappingChange;
import lombok.extern.slf4j.Slf4j;
import net.skhu.aws.AmazonS3Util;
import net.skhu.domain.Member;
import net.skhu.dto.LoginRequest;
import net.skhu.dto.SignUpRequest;
import net.skhu.mapper.MemberMapper;
import net.skhu.service.LoginService;
import net.skhu.service.SignUpService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by bomi on 2019-05-03.
 */

@Slf4j
@Controller
@RequestMapping("/")
public class LoginController {

    private final SignUpService signUpService;

    private final LoginService loginService;

    public LoginController(final SignUpService signUpService, final LoginService loginService) {
        this.signUpService = signUpService;
        this.loginService = loginService;
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
    public String loginError(Model model, HttpServletResponse response) {
        loginService.push(response);
        model.addAttribute("loginError", true);
        model.addAttribute("findError", false);
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

