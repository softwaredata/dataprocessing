package net.skhu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class Election {

    private String name;

    private Date voteStartDate;

    private Date voteEndDate;

    private int type;

    private Date regStartDate;

    private Date regEndDate;

    @Builder
    public Election(String name, Date voteStartDate, Date voteEndDate, int type, Date regStartDate, Date regEndDate) {
        this.name = name;
        this.voteStartDate = voteStartDate;
        this.voteEndDate = voteEndDate;
        this.type = type;
        this.regStartDate = regStartDate;
        this.regEndDate = regEndDate;
    }
}
