/*
minsub
 */
package net.skhu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Team {
    int idx;
    String name;
    String name1;
    String name2;
    int candidate1idx;
    int candidate2idx;
    String pledge;
    String reccoPhotoUrl;
    String electioneeringFileUrl;
    String teamPhotoUrl;
    String oathPhotoUrl;
    int electionIdx;
    String candidate1CertiUrl;
    String candidate2CertiUrl;
    int typeChk;
    String candidate1PhotoUrl;
    String candidate2PhotoUrl;
    String department;

    @Builder
    public Team(int idx, String name, int candidate1idx, int candidate2idx, String pledge, String reccoPhotoUrl,
                String electioneeringFileUrl, String teamPhotoUrl, String oathPhotoUrl, int electionIdx,
                String candidate1CertiUrl, String candidate2CertiUrl, int typeChk, String department) {

        this.idx = idx;
        this.candidate1idx = candidate1idx;
        this.name = name;

        this.candidate2idx = candidate2idx;
        this.pledge =pledge;
        this. reccoPhotoUrl =reccoPhotoUrl;
        this.electioneeringFileUrl =electioneeringFileUrl;
        this.teamPhotoUrl =teamPhotoUrl;
        this.oathPhotoUrl =oathPhotoUrl;
        this.electionIdx =electionIdx;
        this.candidate1CertiUrl =candidate1CertiUrl;
        this.candidate2CertiUrl =candidate2CertiUrl;
        this.typeChk = typeChk;
        this.department=department;

    }

    @Override
    public String toString() {
        return "Team{" +
                "name=" + name +
                ", candidate1idx='" + candidate1idx +
                ", candidate2idx='"+ candidate2idx+
                ", pledge='"+ pledge+
                '\'' +
                '}';
    }


}
