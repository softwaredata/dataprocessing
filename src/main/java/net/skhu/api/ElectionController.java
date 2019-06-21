/*
minsub
 */
package net.skhu.api;

import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Member;
import net.skhu.domain.Team;
import net.skhu.domain.UserToElection;
import net.skhu.mapper.MemberMapper;
import net.skhu.mapper.TeamMapper;
import net.skhu.service.CheckVoteDayPossibleService;
import net.skhu.service.ElectionService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/")
public class ElectionController {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(ElectionController.class);

    private final TeamMapper teamMapper;

    private final ElectionService electionService;

    private final CheckVoteDayPossibleService checkVoteDayPossibleService;

    private final MemberMapper memberMapper;

    public ElectionController(final TeamMapper teamMapper, final ElectionService electionService,
                              final CheckVoteDayPossibleService checkVoteDayPossibleService, final MemberMapper memberMapper) {
        this.teamMapper = teamMapper;
        this.electionService = electionService;
        this.checkVoteDayPossibleService = checkVoteDayPossibleService;
        this.memberMapper = memberMapper;
    }

    @GetMapping("realVote/{electionType}")
    public String election(Model model, @PathVariable("electionType") int electionType, HttpServletResponse response, HttpSession session) throws IOException {

        Member user =(Member)session.getAttribute("user");

        model.addAttribute("electionType",electionType);
        boolean electionCheck= electionService.electionCheck(model,electionType,response);
        if(electionCheck == true) {
            return "election/realVote";
        }
        else
            return "main/main";
    }

    @GetMapping("teamDetail/{electionType}/{teamNum}")
    public String teamDetail(Model model, @PathVariable("electionType") int electionType,
                             @PathVariable("teamNum") int teamNum,HttpSession session){
        Member user =(Member)session.getAttribute("user");

        Team teamDetail =teamMapper.findTeamOfDetail(teamNum);
        Team teamImage = teamMapper.findTeamForCandiImg(teamNum);
        model.addAttribute("teamDetail",teamDetail);
        model.addAttribute("teamImage",teamImage);
        model.addAttribute("vote",electionType);
        return "election/teamDetail";
    }

    @PostMapping("goForVote")
    public void memberToVote(@RequestBody UserToElection userToElection, HttpServletResponse response,HttpSession session) throws IOException {

        Member user =(Member)session.getAttribute("user");

        log.info(userToElection.toString());
        electionService.studentGoVote(userToElection,response);

    }

}
