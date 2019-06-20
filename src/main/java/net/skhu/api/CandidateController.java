package net.skhu.api;

import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Team;
import net.skhu.mapper.TeamMapper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/")
public class CandidateController {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(CandidateController.class);

    private final TeamMapper teamMapper;

    public CandidateController(final TeamMapper teamMapper) {
        this.teamMapper = teamMapper;
    }

    @GetMapping("candidateCheck")
    public String candidateCheck(Model model){
        Team team = teamMapper.findTeamMatchId(201932001);
        model.addAttribute("team",team);
        return "candidate/candidateCheck";
    }

    @GetMapping("candiRegister")
    public String candidateRegit(){

        return "candidate/candidateRegister";
    }

    @PostMapping("register")
    public String teamRegist(Team team,HttpServletRequest request){

        Team team1 =Team.builder()
                .pledge(request.getParameter("pledge"))
                .build();
        logger.info(team1.toString());
        return "redirect:/candiRegister";
    }

}
