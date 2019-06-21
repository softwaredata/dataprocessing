package net.skhu.service;

import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Team;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class S3FileUploadService {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(S3FileUploadService.class);

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
}
