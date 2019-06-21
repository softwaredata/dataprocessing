package net.skhu.api;

import lombok.RequiredArgsConstructor;
import net.skhu.domain.Member;
import net.skhu.domain.UserToElection;
import net.skhu.mapper.ElectionResultMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class VoteResultController {

    private final ElectionResultMapper electionResultMapper;

    @GetMapping("/vote")
    public String totalVote(Model model, UserToElection userToElection, Member member){

        model.addAttribute("abandonment", electionResultMapper.findByElectionAbandonment(userToElection));
        model.addAttribute("vote", electionResultMapper.findByElectionVote(userToElection));

        return "vote/voteResult";
    }

}
