package net.skhu.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
//import org.joda.time.LocalDateTime;


/**
 * Created by bomi on 2019-05-15.
 */

@NoArgsConstructor
@Getter
@Builder
public class Election {
    private long idx;
    private String name;
    private LocalDateTime voteStartDate;
    private LocalDateTime voteEndDate;
    private int type;
    private LocalDateTime regStartDate;
    private LocalDateTime fegEndDate;
}
