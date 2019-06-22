package net.skhu.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Created by bomi on 2019-05-16.
 */

@Getter
@Setter
@NoArgsConstructor
public class ElectionRequest {
    private String title;
    private String voteStartDate;
    private String voteEndDate;
    private String department;
    private String regStartDate;
    private String regEndDate;
    private int name;

    @Builder
    public ElectionRequest(String title, String voteStartDate, String voteEndDate,
                           String department, String regStartDate, String regEndDate, int name) {
        this.title = title;
        this.voteStartDate = voteStartDate;
        this.voteEndDate = voteEndDate;
        this.department = department;
        this.regStartDate = regStartDate;
        this.regEndDate = regEndDate;
        this.name = name;
    }

}
