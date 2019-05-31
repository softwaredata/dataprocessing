package net.skhu.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ElectionVoteDate {

    private LocalDate voteStartDate;

    private LocalDate voteEndDate;

    private int name;

    private int type;

    private int vote;

    private int collegeElectionTotalVote;

    private int underGraduateElectionTotalVote;

    private int majorElectionTotalVote;

    @Builder
    public ElectionVoteDate(LocalDate voteStartDate, LocalDate voteEndDate, int name, int type, int vote, int collegeElectionTotalVote, int underGraduateElectionTotalVote, int majorElectionTotalVote) {
        this.voteStartDate = voteStartDate;
        this.voteEndDate = voteEndDate;
        this.name = name;
        this.type = type;
        this.vote = vote;
        this.collegeElectionTotalVote = collegeElectionTotalVote;
        this.underGraduateElectionTotalVote = underGraduateElectionTotalVote;
        this.majorElectionTotalVote = majorElectionTotalVote;
    }

}
