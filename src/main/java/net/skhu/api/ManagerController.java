package net.skhu.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Member;
import net.skhu.mapper.TeamsMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ManagerController {

    private final TeamsMapper teamsMapper;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/list")
    public String findCandidate(Model model, Member member){
        model.addAttribute("selectCandidate", teamsMapper.findByTeams());
        return "manager/listCandidate";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/update")
    public String updateTeam(@RequestParam("idx") int idx, Member member){
        teamsMapper.updateTeams(idx);
        return "redirect:list";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/delete")
    public String deleteTeam(@RequestParam("idx") int idx, Member member) {
        teamsMapper.deleteTeams(idx);
        return "redirect:list";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/team")
    public String teamInformation(Model model, @RequestParam("idx") int idx,
                                  @RequestParam("candidate1Idx") int candidate1Idx,
                                  @RequestParam("candidate2Idx") int candidate2Idx){
        model.addAttribute("team",teamsMapper.findByCandidateTeam(idx));
        model.addAttribute("teamSub",teamsMapper.findBySubCandidateTeam(idx));
        model.addAttribute("candidate",teamsMapper.findByCandidateMember(candidate1Idx));
        model.addAttribute("subCandidate",teamsMapper.findBySubCandidateMember(candidate2Idx));
        model.addAttribute("picture",teamsMapper.findByPicture(idx));
        return "manager/candidateInformation";
    }
}
