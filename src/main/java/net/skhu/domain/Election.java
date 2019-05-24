package net.skhu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private LocalDateTime regEndDate;
}
