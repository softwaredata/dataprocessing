/*
minsub
 */
package net.skhu.api;

import lombok.extern.slf4j.Slf4j;


import net.skhu.domain.Member;
import net.skhu.domain.Election;
import net.skhu.aws.AmazonS3Util;

import net.skhu.domain.Team;
import net.skhu.domain.UserToElection;
import net.skhu.dto.ElectionRequest;
import net.skhu.mapper.MemberMapper;
import net.skhu.mapper.TeamMapper;
import net.skhu.service.CheckVoteDayPossibleService;
import net.skhu.service.ElectionService;

import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/")
public class ElectionController {

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
        if(electionCheck){
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

    //@Secured("ROLE_ADMIN")
    @GetMapping("admin/electionManagement")
   public String electionManagement(@RequestParam(value = "type", required = false)final String type, Model model, HttpServletResponse response,HttpSession session) throws IOException {
        Member user =(Member)session.getAttribute("user");

        ElectionRequest election = electionService.getElection(type, response);
        model.addAttribute("election", election);
        model.addAttribute("type", type);
        return  "admin/electionManagement";
    }

    @PostMapping("admin/electionManagement")
    public void electionManagement(@RequestBody ElectionRequest electionRequest, HttpServletResponse response,HttpSession session) throws IOException {
        Member user = (Member) session.getAttribute("user");
        //Election election = electionService.setElection(electionRequest, response);
        electionService.setElection(electionRequest, response);


//        if(election == null) {
//            return "redirect:/admin/electionManagement";
//        }
//        else {
//
//            return "redirect:/main";
//        }
//    }

    }

}
