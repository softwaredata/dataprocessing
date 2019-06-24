package net.skhu.api;

import lombok.extern.slf4j.Slf4j;

import net.skhu.config.security.SecurityAdminDetails;

import net.skhu.aws.AmazonS3Util;

import net.skhu.domain.SecurityUser;
import net.skhu.mapper.TeamMapper;
import net.skhu.service.CheckVoteDayPossibleService;
import net.skhu.service.ElectionService;

import net.skhu.domain.Member;
import net.skhu.mapper.MemberMapper;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
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

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("main")
    public String main(HttpSession session, Model model) {
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
    public String postmain(HttpSession session, Model model){
        System.out.println("mainController-post");
        // TODO- 세션 관리
        SecurityAdminDetails securityAdminDetails = (SecurityAdminDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        String one = AmazonS3Util.getFileURL("총학생회.jpg");
//        String two = AmazonS3Util.getFileURL("학부대표.jpg");
//        String three =AmazonS3Util.getFileURL("전공대표.jpg");
//        model.addAttribute("one",one);
//        model.addAttribute("two",two);
//        model.addAttribute("three",three);

        Member user = securityAdminDetails.getMember();
        session.setAttribute("user", user);
        //log.error(user.toString());
        //model.addAttribute("user", user);
        return "redirect:main";
    }


}
