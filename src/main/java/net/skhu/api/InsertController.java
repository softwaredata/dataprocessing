package net.skhu.api;


import lombok.extern.slf4j.Slf4j;
import net.skhu.aws.AmazonS3Util;
import net.skhu.domain.Candidate;
import net.skhu.domain.Team;
import net.skhu.mapper.CandidateMapper;
import net.skhu.mapper.TeamMapper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/")
public class InsertController {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(InsertController.class);

    private final TeamMapper teamMapper;

    private final CandidateMapper candidateMapper;

    public InsertController(TeamMapper teamMapper, CandidateMapper candidateMapper) {
        this.teamMapper = teamMapper;
        this.candidateMapper = candidateMapper;
    }


    //입후보 등록
    @GetMapping("register")
    public String createCandidate(Model model ){




        return "users/register";
    }

    @PostMapping("register")
    public String createRegister(@RequestBody Team team) {
        logger.info(team.toString());
        AmazonS3Util.uploadFile( team.getName()+"_공약", team.getPledge());
        logger.info(AmazonS3Util.getFileURL(team.getName()+"_공약"));
        AmazonS3Util.uploadFile( team.getName()+"_추천서", team.getReccoPhotoUrl());
        AmazonS3Util.uploadFile( team.getName()+"_선거운동단", team.getElectioneeringFileUrl());
        AmazonS3Util.uploadFile( team.getName()+"_팀사진", team.getTeamPhotoUrl());
        AmazonS3Util.uploadFile( team.getName()+"_선거서약서", team.getOathPhotoUrl());
        AmazonS3Util.uploadFile( team.getName()+"_정후보_재학증명서", team.getCandidate1CertiUrl());
        AmazonS3Util.uploadFile( team.getName()+"_부후보_재학증명서", team.getCandidate2CertiUrl());

        AmazonS3Util.uploadFile( team.getName()+"_정후보_프로필사진", team.getCandidate1PhotoUrl());
        AmazonS3Util.uploadFile( team.getName()+"_부후보_프로필사진", team.getCandidate2PhotoUrl());

        Candidate candidate1 = Candidate.builder()
                .idx(team.getCandidate1idx())
                .profileUrl(AmazonS3Util.getFileURL(team.getName()+"_정후보_프로필사진"))
                .build();

        Candidate candidate2 = Candidate.builder()
                .idx(team.getCandidate2idx())
                .profileUrl(AmazonS3Util.getFileURL(team.getName()+"_부후보_프로필사진"))
                .build();

        candidateMapper.insertCandidate(candidate1);
        candidateMapper.insertCandidate(candidate2);


        Team insertTeam = Team.builder()
                .name(team.getName())
                .candidate1idx(team.getCandidate1idx())
                .candidate2idx(team.getCandidate2idx())
                .pledge(AmazonS3Util.getFileURL(team.getName()+"_공약"))
                .reccoPhotoUrl(AmazonS3Util.getFileURL(team.getName()+"_추천서"))
                .electioneeringFileUrl(AmazonS3Util.getFileURL(team.getName()+"_선거운동단"))
                .teamPhotoUrl(AmazonS3Util.getFileURL(team.getName()+"_팀사진"))
                .oathPhotoUrl(AmazonS3Util.getFileURL(team.getName()+"_선거서약서"))
                .candidate1CertiUrl(AmazonS3Util.getFileURL(team.getName()+"_정후보_재학증명서"))
                .candidate2CertiUrl(AmazonS3Util.getFileURL(team.getName()+"_정후보_재학증명서"))
                .typeChk(0)
                .electionIdx(team.getElectionIdx())
                .department(team.getDepartment())
                .build();

        teamMapper.insertTeam(insertTeam);

        return "redirect:/main";

    }


}
