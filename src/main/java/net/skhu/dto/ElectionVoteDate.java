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

    private String name;

    private int type;

    @Builder
    public ElectionVoteDate(LocalDate voteStartDate, LocalDate voteEndDate, String name, int type) {
        this.voteStartDate = voteStartDate;
        this.voteEndDate = voteEndDate;
        this.name = name;
        this.type = type;
    }

}
