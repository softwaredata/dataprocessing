package net.skhu.api;

import lombok.RequiredArgsConstructor;
import net.skhu.mapper.ElectionResultMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class VoteResultController {

    private final ElectionResultMapper electionResultMapper;

    @PreAuthorize("hasAuthority('ROLE_USER') OR hasAuthority('ROLE_ADMIN')")
    @GetMapping("vote")
    public String totalVote(Model model, @RequestParam("electionidx") int electionidx){

        model.addAttribute("abandonment", electionResultMapper.findByElectionAbandonment(electionidx));
        model.addAttribute("vote", electionResultMapper.findByElectionVote(electionidx));
        model.addAttribute("image",electionResultMapper.findByCandidateImages(electionResultMapper.findByCandidateInformation(electionidx)));
        model.addAttribute("endTime",electionResultMapper.findByEndTime(electionidx));
        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("electionidx",electionidx);
        return "vote/voteResult";
    }

}
