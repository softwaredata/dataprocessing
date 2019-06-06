package net.skhu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Candidate {
    int idx; //studentIdx
    String profileUrl;

    @Builder
    public Candidate(int idx, String profileUrl){
        this.idx = idx;
        this.profileUrl = profileUrl;
    }

}
