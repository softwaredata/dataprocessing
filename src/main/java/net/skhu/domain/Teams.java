package net.skhu.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Teams {

    private long idx;

    private String name;

    private int candidate1Idx;

    private int candidate2Idx;

    private String pledge;

    private String reccoPhotoUrl;

    private String electioneeringFileUrl;

    private String teamPhotoUrl;

    private String oathPhotoUrl;

    private int electionIdx;

    private String candidate1CertiUrl;

    private String candidate2CertiUrl;

    private int typeChk;

    @Builder
    public Teams(int idx,String name, int candidate1Idx, int candidate2Idx, String pledge, String reccoPhotoUrl, String electioneeringFileUrl, String teamPhotoUrl, String oathPhotoUrl,
                 int electionIdx, String candidate1CertiUrl, String candidate2CertiUrl, int typeChk){

        this.idx = idx;
        this.name = name;
        this.candidate1Idx = candidate1Idx;
        this.candidate2Idx = candidate2Idx;
        this.pledge = pledge;
        this.reccoPhotoUrl = reccoPhotoUrl;
        this.electioneeringFileUrl = electioneeringFileUrl;
        this.teamPhotoUrl = teamPhotoUrl;
        this.oathPhotoUrl = oathPhotoUrl;
        this.electionIdx = electionIdx;
        this.candidate1CertiUrl = candidate1CertiUrl;
        this.candidate2CertiUrl = candidate2CertiUrl;
        this.typeChk = typeChk;

    }
}
