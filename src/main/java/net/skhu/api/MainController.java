package net.skhu.api;

import lombok.extern.slf4j.Slf4j;

import net.skhu.config.security.SecurityAdminDetails;
import net.skhu.mapper.TeamMapper;
import net.skhu.service.CheckVoteDayPossibleService;
import net.skhu.service.ElectionService;

import net.skhu.domain.Member;
import net.skhu.mapper.MemberMapper;

import org.slf4j.LoggerFactory;
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

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("main")
    public String main(HttpSession session, Model model) {
        System.out.println("mainController");
        Member user = (Member) session.getAttribute("user");
        System.out.println(user);
        return "main/main";
    }

    @PostMapping("main")
    public String postmain(HttpSession session, Model model){
        System.out.println("mainController");
        SecurityAdminDetails securityAdminDetails = (SecurityAdminDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Member user = securityAdminDetails.getMember();
        log.error(user.toString());
        model.addAttribute("user", user);
        return "main/main";
    }


}
