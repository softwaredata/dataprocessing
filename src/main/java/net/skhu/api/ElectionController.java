/*
minsub
 */
package net.skhu.api;

import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Election;
import net.skhu.domain.Team;
import net.skhu.domain.UserToElection;
import net.skhu.mapper.TeamMapper;
import net.skhu.service.CheckVoteDayPossibleService;
import net.skhu.service.ElectionService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/")
public class ElectionController {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(ElectionController.class);

    private final TeamMapper teamMapper;

    private final ElectionService electionService;

    private final CheckVoteDayPossibleService checkVoteDayPossibleService;

    public ElectionController(final TeamMapper teamMapper,final ElectionService electionService,
                          final CheckVoteDayPossibleService checkVoteDayPossibleService) {
        this.teamMapper = teamMapper;
        this.electionService = electionService;
        this.checkVoteDayPossibleService = checkVoteDayPossibleService;
    }

    @GetMapping("election/{vote}")
    public String election(Model model, @PathVariable("vote") int vote, HttpServletResponse response) throws IOException {
        model.addAttribute("vote",vote);
        boolean electionCheck= electionService.electionCheck(model,vote,response);
        if(electionCheck == true)
            return "election/election1";
        else
            return "main/main";
    }

    @GetMapping("teamDetail/{vote}/{teamNum}")
    public String teamDetail(Model model,UserToElection userToElection, @PathVariable("vote") int vote,@PathVariable("teamNum") int teamNum){
        Team teamDetail =teamMapper.findTeamOfDetail(teamNum);

        model.addAttribute("teamDetail",teamDetail);
        model.addAttribute("vote",vote);
        return "election/teamDetail";
    }

    @PostMapping("goForVote")
    public void memberToVote(@Param("studentidx") int studentidx,@Param("electionidx") int electionidx, HttpServletResponse response) throws IOException {
        UserToElection userToElection=UserToElection.builder()
                .studentidx(studentidx)
                .electionidx(electionidx)
                .build();
        electionService.studentGoVote(userToElection,response);

    }

}
