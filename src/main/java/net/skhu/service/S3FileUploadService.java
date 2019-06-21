package net.skhu.service;

import lombok.extern.slf4j.Slf4j;
import net.skhu.api.CandidateController;
import net.skhu.aws.AmazonS3Util;
import net.skhu.domain.Team;
import org.apache.http.HttpResponse;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Service
public class S3FileUploadService {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(CandidateController.class);
//    private final AmazonS3Util amazonS3Util;
//
//    public S3FileUploadService(AmazonS3Util amazonS3Util) {
//        this.amazonS3Util = amazonS3Util;
//    }
//
    public boolean registVaildateCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        int candidate1idx;
        int candidate2idx;

        if(request.getParameter("candidate1idx")==""||request.getParameter("candidate1idx")==null){
            candidate1idx=0;
        }
        else
            candidate1idx=Integer.parseInt(request.getParameter("candidate1idx"));

        if(request.getParameter("candidate2idx")==""||request.getParameter("candidate2idx")==null){
            candidate2idx=0;
        }
        else
            candidate2idx=Integer.parseInt(request.getParameter("candidate2idx"));

        Team team =Team.builder()
                .name(request.getParameter("name"))
                .candidate1idx(candidate1idx)
                .candidate2idx(candidate2idx)
                .electionIdx(Integer.parseInt(request.getParameter("electionIdx")))
                .pledge(request.getParameter("pledge"))
                .reccoPhotoUrl(request.getParameter("reccoPhotoUrl"))
                .electioneeringFileUrl(request.getParameter("electioneeringFileUrl"))
                .teamPhotoUrl(request.getParameter("teamPhotoUrl"))
                .oathPhotoUrl(request.getParameter("oathPhotoUrl"))
                .candidate1CertiUrl(request.getParameter("candidate1CertiUrl"))
                .candidate2CertiUrl(request.getParameter("candidate2CertiUrl"))
                .build();

        logger.info(team.toString());

        if(team.getName()==null || team.getCandidate1idx()==0 || team.getCandidate2idx()==0 || team.getPledge()==""
                || team.getReccoPhotoUrl()=="" || team.getElectioneeringFileUrl()=="" || team.getTeamPhotoUrl()=="" ||
                team.getOathPhotoUrl()=="" || team.getCandidate1CertiUrl()=="" || team.getCandidate2CertiUrl()==""){
            out.println("<script>alert('정보를 모두 입력하세요'); history.go(-1);</script>");
            out.flush();
            return false;
        }
        else
            return true;
    }
}
