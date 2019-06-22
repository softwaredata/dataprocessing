package net.skhu.api;

import lombok.RequiredArgsConstructor;
import net.skhu.mapper.ElectionResultMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class VoteResultController {

    private final ElectionResultMapper electionResultMapper;

    @GetMapping("vote")
    public String totalVote(Model model, @RequestParam("electionidx") int electionidx){

        model.addAttribute("abandonment", electionResultMapper.findByElectionAbandonment(electionidx));
        model.addAttribute("vote", electionResultMapper.findByElectionVote(electionidx));
        model.addAttribute("image",electionResultMapper.findByCandidateImages(10));

        return "vote/voteResult";
    }

}
