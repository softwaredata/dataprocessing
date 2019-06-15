package net.skhu.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Team {

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


}
