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
    int candidate1_Idx;
    int candidate2_Idx;
    String pledge;
    String reccoPhotoUrl;
    String electioneeringFileUrl;
    String teamPhotoUrl;
    String oathPhotoUrl;
    int electionIdx;
    String candidate1CertiUrl;
    String candidate2CertiUrl;
    int typeChk;

    @Builder
    public Team(int idx, String name, int candidate1_Idx, int candidate2_Idx, String pledge, String reccoPhotoUrl,
                String electioneeringFileUrl, String teamPhotoUrl, String oathPhotoUrl, int electionIdx,
                String candidate1CertiUrl, String candidate2CertiUrl, int typeChk){

        this.idx = idx;
        this.candidate1_Idx = candidate1_Idx;
        this.candidate2_Idx = candidate2_Idx;
        this.pledge =pledge;
        this. reccoPhotoUrl =reccoPhotoUrl;
        this.electioneeringFileUrl =electioneeringFileUrl;
        this.teamPhotoUrl =teamPhotoUrl;
        this.oathPhotoUrl =oathPhotoUrl;
        this.electionIdx =electionIdx;
        this.candidate1CertiUrl =candidate1CertiUrl;
        this.candidate2CertiUrl =candidate2CertiUrl;
        this.typeChk = typeChk;
    }




}
