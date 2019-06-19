/*
minsub
 */
package net.skhu.api;

import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Team;
import net.skhu.domain.UserToElection;
import net.skhu.mapper.TeamMapper;
import net.skhu.service.CheckVoteDayPossibleService;
import net.skhu.service.ElectionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/")
public class ElectionController {

    private final TeamMapper teamMapper;

    private final ElectionService electionService;

    private final CheckVoteDayPossibleService checkVoteDayPossibleService;

    public ElectionController(final TeamMapper teamMapper,final ElectionService electionService,
                          final CheckVoteDayPossibleService checkVoteDayPossibleService) {
        this.teamMapper = teamMapper;
        this.electionService = electionService;
        this.checkVoteDayPossibleService = checkVoteDayPossibleService;
    }

    @GetMapping("realVote/{electionType}")
    public String election(Model model, @PathVariable("electionType") int electionType, HttpServletResponse response) throws IOException {
        model.addAttribute("electionType",electionType);
        boolean electionCheck= electionService.electionCheck(model,electionType,response);
        if(electionCheck)
            return "election/realVote";
        else
            return "main/main";
    }

    @GetMapping("teamDetail/{electionType}/{teamNum}")
    public String teamDetail(Model model, @PathVariable("electionType") int electionType,
                             @PathVariable("teamNum") int teamNum){
        Team teamDetail =teamMapper.findTeamOfDetail(teamNum);

        model.addAttribute("teamDetail",teamDetail);
        model.addAttribute("vote",electionType);
        return "election/teamDetail";
    }

    @PostMapping("goForVote")
    public void memberToVote(@RequestBody UserToElection userToElection, HttpServletResponse response) throws IOException {

        log.info(userToElection.toString());
        electionService.studentGoVote(userToElection,response);

    }

}
