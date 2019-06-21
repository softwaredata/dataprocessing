/*
minsub
 */
package net.skhu.api;

import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Election;
import net.skhu.domain.Team;
import net.skhu.domain.UserToElection;
import net.skhu.dto.ElectionRequest;
import net.skhu.mapper.TeamMapper;
import net.skhu.service.CheckVoteDayPossibleService;
import net.skhu.service.ElectionService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("realVote/{electionType}")
    public String election(Model model, @PathVariable("electionType") int electionType, HttpServletResponse response) throws IOException {
        model.addAttribute("electionType",electionType);
        boolean electionCheck= electionService.electionCheck(model,electionType,response);
        if(electionCheck == true)
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

    //@Secured("ROLE_ADMIN")
    @GetMapping("admin/electionManagement")
    public String electionManagement(@RequestParam(value = "type", required = false)final String type, Model model, HttpServletResponse response) throws IOException {
        ElectionRequest election = electionService.getElection(type, response);
        model.addAttribute("election", election);
        model.addAttribute("type", type);
        return  "admin/electionManagement";
    }

    @PostMapping("admin/electionManagement")
    public String electionManagement(@RequestBody ElectionRequest electionRequest, HttpServletResponse response) throws IOException {
        Election election = electionService.setElection(electionRequest, response);

        if(election == null) {
            return "redirect:admin/electionManagement";
        }

        return "main/main";
    }

}
