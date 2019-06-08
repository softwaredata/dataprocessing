package net.skhu.api;

import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Team;
import net.skhu.mapper.TeamMapper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class MainController {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MainController.class);

    private final TeamMapper teamMapper;

    public MainController(final TeamMapper teamMapper) {
        this.teamMapper = teamMapper;
    }


    @GetMapping("main")
    public String main(){

        return "main/main";
    }

    @GetMapping("election/{vote}")
    public String election(Model model, @PathVariable("vote") int vote){
        model.addAttribute("vote",vote);
        List<Team> teamList = teamMapper.findTeams(vote);
        model.addAttribute("teamList",teamList);
        return "election/election1";
    }

    @GetMapping("teamDetail/{vote}/{teamNum}")
    public String teamDetail(Model model, @PathVariable("vote") int vote,@PathVariable("teamNum") int teamNum){
        Team teamDetail =teamMapper.findTeamOfDetail(teamNum);

        model.addAttribute("teamDetail",teamDetail);
        model.addAttribute("vote",vote);
        return "election/teamDetail";
    }


}
