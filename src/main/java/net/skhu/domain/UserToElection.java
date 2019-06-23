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

    private int studentidx;

    private int electionidx;

    private Integer teamidx;

    private int abandonment;

    @Builder
    public UserToElection(int studentidx,int electionidx, Integer teamidx, int abandonment){
        this.studentidx = studentidx;
        this.electionidx = electionidx;
        this.teamidx = teamidx;
        this.abandonment =abandonment;
    }

    @Override
    public String toString() {
        return "UserToElection{" +
                "studentidx=" + studentidx +
                ", electionidx=" + electionidx +
                ", teamidx=" + teamidx +
                ", abandonment=" + abandonment +
                '}';
    }
}
