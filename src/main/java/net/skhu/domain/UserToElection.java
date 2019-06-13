/*
minsub
 */
package net.skhu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserToElection {
    int studentidx;
    int electionidx;

    @Builder
    public UserToElection(int studentidx,int electionidx){
        this.studentidx = studentidx;
        this.electionidx = electionidx;
    }
}
