package net.skhu.api;

import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Team;
import net.skhu.mapper.TeamMapper;
import net.skhu.service.CheckVoteDayPossibleService;
import net.skhu.service.ElectionService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class MainController {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MainController.class);

    private final TeamMapper teamMapper;

    private final ElectionService electionService;

    private final CheckVoteDayPossibleService checkVoteDayPossibleService;

    public MainController(final TeamMapper teamMapper,final ElectionService electionService,
                          final CheckVoteDayPossibleService checkVoteDayPossibleService) {
        this.teamMapper = teamMapper;
        this.electionService = electionService;
        this.checkVoteDayPossibleService = checkVoteDayPossibleService;
    }


    @GetMapping("main")
    public String main(){

        return "main/main";
    }

    @GetMapping("election/{vote}")
    public String election(Model model, @PathVariable("vote") int vote, HttpServletResponse response) throws IOException {
        model.addAttribute("vote",vote);
        return electionService.electionCheck(model,vote,response);

    }

    @GetMapping("teamDetail/{vote}/{teamNum}")
    public String teamDetail(Model model, @PathVariable("vote") int vote,@PathVariable("teamNum") int teamNum){
        Team teamDetail =teamMapper.findTeamOfDetail(teamNum);

        model.addAttribute("teamDetail",teamDetail);
        model.addAttribute("vote",vote);
        return "election/teamDetail";
    }


}
