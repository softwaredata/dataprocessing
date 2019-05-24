package net.skhu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class Election {

    private String name;

    private LocalDate voteStartDate;

    private LocalDate voteEndDate;

    private int type;

    private LocalDate regStartDate;

    private LocalDate regEndDate;

    private int collegeElectionTotalVote;

    private int underGraduateElectionTotalVote;

    private int majorElectionTotalVote;

    @Builder
    public Election(String name, LocalDate voteStartDate, LocalDate voteEndDate, int type, LocalDate regStartDate, LocalDate regEndDate, int collegeElectionTotalVote, int underGraduateElectionTotalVote, int majorElectionTotalVote) {
        this.name = name;
        this.voteStartDate = voteStartDate;
        this.voteEndDate = voteEndDate;
        this.type = type;
        this.regStartDate = regStartDate;
        this.regEndDate = regEndDate;
        this.collegeElectionTotalVote = collegeElectionTotalVote;
        this.underGraduateElectionTotalVote = underGraduateElectionTotalVote;
        this.majorElectionTotalVote = majorElectionTotalVote;
    }
}
