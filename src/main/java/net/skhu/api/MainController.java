package net.skhu.api;

import lombok.extern.slf4j.Slf4j;

import net.skhu.config.security.SecurityUserDetails;

import net.skhu.aws.AmazonS3Util;

import net.skhu.domain.Member;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/")
public class MainController {

    @PreAuthorize("hasAuthority('ROLE_USER') OR hasAuthority('ROLE_ADMIN')")
    @GetMapping("main")
    public String userMain(HttpSession session, Model model) {
        System.out.println("mainController-get");
        Member user = (Member) session.getAttribute("user");

        String one = AmazonS3Util.getFileURL("총학생회.jpg");
        String two = AmazonS3Util.getFileURL("학부대표.jpg");
        String three =AmazonS3Util.getFileURL("전공대표.jpg");
        model.addAttribute("one",one);
        model.addAttribute("two",two);
        model.addAttribute("three",three);

        return "main/main";
    }


    @PostMapping("main")
    public String postMain(HttpSession session, Model model){
        System.out.println("mainController-post");
        // TODO- 세션 관리
        SecurityUserDetails securityUserDetails = (SecurityUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Member user = securityUserDetails.getMember();

        session.setAttribute("user", user);
        //log.error(user.toString());
        //model.addAttribute("user", user);

        return "redirect:main";
    }


}
