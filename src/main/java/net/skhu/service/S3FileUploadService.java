package net.skhu.service;

import lombok.extern.slf4j.Slf4j;

import net.skhu.api.CandidateController;
import net.skhu.aws.AmazonS3Util;
import net.skhu.domain.Candidate;

import net.skhu.domain.Team;
import net.skhu.mapper.CandidateMapper;
import net.skhu.mapper.TeamMapper;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class S3FileUploadService {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(S3FileUploadService.class);
    private final TeamMapper teamMapper;
    private final CandidateMapper candidateMapper;

    public S3FileUploadService(final TeamMapper teamMapper, final CandidateMapper candidateMapper) {
        this.teamMapper = teamMapper;
        this.candidateMapper = candidateMapper;
    }

    public boolean registVaildateCheck(Team team) throws IOException {
        logger.info(team.toString());

        if(team.getName()==null || team.getCandidate1idx()==0 || team.getCandidate2idx()==0 || team.getPledge()==""
                || team.getReccoPhotoUrl()=="" || team.getElectioneeringFileUrl()=="" || team.getTeamPhotoUrl()=="" ||
                team.getOathPhotoUrl()=="" || team.getCandidate1CertiUrl()=="" || team.getCandidate2CertiUrl()=="" ||team.getProfileUrl1()==""||
                team.getProfileUrl2()==""){
            return false;
        }
        else
            return true;
    }

    public void registerS3FileUpload(Team team) throws IOException {

//        AmazonS3Util.uploadFile( team.getName().charAt(0)+"pledge", team.getPledge());
//        AmazonS3Util.uploadFile( team.getName().charAt(0)+"reccoPhoto", team.getReccoPhotoUrl());
//        AmazonS3Util.uploadFile( team.getName().charAt(0)+"electioneering", team.getElectioneeringFileUrl());
//        AmazonS3Util.uploadFile( team.getName().charAt(0)+"teamPhoto", team.getTeamPhotoUrl());
//        AmazonS3Util.uploadFile( team.getName().charAt(0)+"oathPhoto", team.getOathPhotoUrl());
//        AmazonS3Util.uploadFile( team.getName().charAt(0)+"candi1Certi", team.getCandidate1CertiUrl());
//        AmazonS3Util.uploadFile( team.getName().charAt(0)+"candi2Certi", team.getCandidate2CertiUrl());
//        AmazonS3Util.uploadFile( team.getName().charAt(0)+"candi1Profile", team.getProfileUrl1());
//        AmazonS3Util.uploadFile( team.getName().charAt(0)+"candi2Profile", team.getProfileUrl2());

        AmazonS3Util.uploadFile( team.getName()+"pledge", team.getPledge());
        AmazonS3Util.uploadFile( team.getName()+"reccoPhoto", team.getReccoPhotoUrl());
        AmazonS3Util.uploadFile( team.getName()+"electioneering", team.getElectioneeringFileUrl());
        AmazonS3Util.uploadFile( team.getName()+"teamPhoto", team.getTeamPhotoUrl());
        AmazonS3Util.uploadFile( team.getName()+"oathPhoto", team.getOathPhotoUrl());
        AmazonS3Util.uploadFile( team.getName()+"candi1Certi", team.getCandidate1CertiUrl());
        AmazonS3Util.uploadFile( team.getName()+"candi2Certi", team.getCandidate2CertiUrl());
        AmazonS3Util.uploadFile( team.getName()+"candi1Profile", team.getProfileUrl1());
        AmazonS3Util.uploadFile( team.getName()+"candi2Profile", team.getProfileUrl2());

        Candidate candidate1 = Candidate.builder()
                .idx(team.getCandidate1idx())
                .profileUrl(AmazonS3Util.getFileURL(team.getName()+"candi1Profile"))
                .build();

        Candidate candidate2 = Candidate.builder()
                .idx(team.getCandidate2idx())
                .profileUrl(AmazonS3Util.getFileURL(team.getName()+"candi2Profile"))
                .build();

        candidateMapper.insertCandidate(candidate1);
        candidateMapper.insertCandidate(candidate2);


        Team insertTeam = Team.builder()
                .name(team.getName())
                .candidate1idx(team.getCandidate1idx())
                .candidate2idx(team.getCandidate2idx())
                .pledge(AmazonS3Util.getFileURL(team.getName()+"pledge"))
                .reccoPhotoUrl(AmazonS3Util.getFileURL(team.getName()+"reccoPhoto"))
                .electioneeringFileUrl(AmazonS3Util.getFileURL(team.getName()+"electioneering"))
                .teamPhotoUrl(AmazonS3Util.getFileURL(team.getName()+"teamPhoto"))
                .oathPhotoUrl(AmazonS3Util.getFileURL(team.getName()+"oathPhoto"))
                .candidate1CertiUrl(AmazonS3Util.getFileURL(team.getName()+"candi1Certi"))
                .candidate2CertiUrl(AmazonS3Util.getFileURL(team.getName()+"candi2Certi"))
                .typeChk(0)
                .electionIdx(team.getElectionIdx())
                .build();

        teamMapper.insertTeam(insertTeam);

    }
    public boolean alreadyRegistCheck(Team team){
        if(teamMapper.registPossible(team)>0)
            return false;
        else
            return true;
    }
}
