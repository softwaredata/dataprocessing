package net.skhu.api;

import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Member;
import net.skhu.mapper.MemberMapper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/")
public class MainController {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("main")
    public String main(HttpSession session, Model model){
        Member user =(Member)session.getAttribute("user");

        return "main/main";
    }




}
