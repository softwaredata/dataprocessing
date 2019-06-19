package net.skhu.api;


import lombok.extern.slf4j.Slf4j;
import net.skhu.aws.AmazonS3Util;
import net.skhu.domain.Team;
import org.apache.ibatis.annotations.Insert;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Slf4j
@Controller
@RequestMapping("/")
public class InsertController {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(InsertController.class);


    //입후보 등록
    @GetMapping("register")
    public String createCandidate(Model model ){




        return "users/register";
    }

    @PostMapping("register")
    public String createRegister(@RequestBody Team team, HttpServletResponse response) throws Exception{
        logger.info(team.toString());
        AmazonS3Util.uploadFile("team1", team.getPledge());
        logger.info(AmazonS3Util.getFileURL("team1"));

        return "redirect:/main";

    }


}
