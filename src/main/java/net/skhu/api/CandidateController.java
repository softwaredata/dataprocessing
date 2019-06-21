package net.skhu.api;

import lombok.extern.slf4j.Slf4j;
import net.skhu.aws.AmazonS3Util;
import net.skhu.domain.Candidate;
import net.skhu.domain.Team;
import net.skhu.mapper.CandidateMapper;
import net.skhu.mapper.TeamMapper;
import net.skhu.service.S3FileUploadService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Controller
@RequestMapping("/")
public class CandidateController {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(CandidateController.class);

    private final TeamMapper teamMapper;

    private final S3FileUploadService s3FileUploadService;

    private final CandidateMapper candidateMapper;

    public CandidateController(final TeamMapper teamMapper, final S3FileUploadService s3FileUploadService, CandidateMapper candidateMapper) {
        this.teamMapper = teamMapper;
        this.s3FileUploadService = s3FileUploadService;
        this.candidateMapper = candidateMapper;
    }

    @GetMapping("candidateCheck")
    public String candidateCheck(Model model){
        Team team = teamMapper.findTeamMatchId(201932001);
        model.addAttribute("team",team);
        return "candidate/candidateCheck";
    }

    //입후보 등록
    @GetMapping("candiRegister")
    public String createCandidate(Model model){
        return "candidate/register";
    }

    @PostMapping("register")
    public String createRegister(@RequestBody Team team, HttpServletResponse response,HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        boolean check=s3FileUploadService.registVaildateCheck(team);
        if(check==false) {

            out.println("정보를 모두 입력하세요");
            out.close();
            return "candidate/register";
        }
        else {
            logger.info(team.toString());
            AmazonS3Util.uploadFile( team.getName()+"_공약", team.getPledge());
            logger.info(AmazonS3Util.getFileURL(team.getName()+"_공약"));
            AmazonS3Util.uploadFile( team.getName()+"_추천서", team.getReccoPhotoUrl());
            AmazonS3Util.uploadFile( team.getName()+"_선거운동단", team.getElectioneeringFileUrl());
            AmazonS3Util.uploadFile( team.getName()+"_팀사진", team.getTeamPhotoUrl());
            AmazonS3Util.uploadFile( team.getName()+"_선거서약서", team.getOathPhotoUrl());
            AmazonS3Util.uploadFile( team.getName()+"_정후보_재학증명서", team.getCandidate1CertiUrl());
            AmazonS3Util.uploadFile( team.getName()+"_부후보_재학증명서", team.getCandidate2CertiUrl());
            AmazonS3Util.uploadFile( team.getName()+"_정후보_프로필사진", team.getProfileUrl1());
            AmazonS3Util.uploadFile( team.getName()+"_부후보_프로필사진", team.getProfileUrl2());

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
                    .build();

            teamMapper.insertTeam(insertTeam);
            out.println("후보 등록 신청이 되었습니다. 관리자의 승인을 기다려 주세요");
            out.flush();

            return "redirect:/main";
        }

    }

}
