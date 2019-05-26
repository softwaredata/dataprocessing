package net.skhu.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by bomi on 2019-05-16.
 */

@Getter
@NoArgsConstructor
public class ElectionRequest {
    private int name;
    private String voteStartDate;
    private String voteEndDate;
    private int type;
    private String regStartDate;
    private String regEndDate;
}
