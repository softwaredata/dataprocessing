package net.skhu.api;

import lombok.extern.slf4j.Slf4j;
import net.skhu.aws.AmazonS3Util;
import net.skhu.domain.Team;
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

@Slf4j
@Controller
@RequestMapping("/")
public class CandidateController {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(CandidateController.class);

    private final TeamMapper teamMapper;

    private final S3FileUploadService s3FileUploadService;

    public CandidateController(final TeamMapper teamMapper, final S3FileUploadService s3FileUploadService) {
        this.teamMapper = teamMapper;
        this.s3FileUploadService = s3FileUploadService;
    }

    @GetMapping("candidateCheck")
    public String candidateCheck(Model model){
        Team team = teamMapper.findTeamMatchId(201932001);
        model.addAttribute("team",team);
        return "candidate/candidateCheck";
    }

    @GetMapping("candiRegister")
    public String candidateRegit(){

        return "candidate/candidateRegister";
    }

    @PostMapping("register")
    public String teamRegist(@RequestBody Team team, HttpServletRequest request){

//        Team team1 =Team.builder()
//                .name(request.getParameter("name"))
//                .candidate1idx(Integer.parseInt(request.getParameter("candidate1idx")))
//                .candidate2idx(Integer.parseInt(request.getParameter("candidate2idx")))
//                .electionIdx(Integer.parseInt(request.getParameter("electionIdx")))
//                .pledge(request.getParameter("pledge"))
//                .reccoPhotoUrl(request.getParameter("reccoPhotoUrl"))
//                .electioneeringFileUrl(request.getParameter("electioneeringFileUrl"))
//                .teamPhotoUrl(request.getParameter("teamPhotoUrl"))
//                .oathPhotoUrl(request.getParameter("oathPhotoUrl"))
//                .candidate1CertiUrl(request.getParameter("candidate1CertiUrl"))
//                .candidate2CertiUrl(request.getParameter("candidate2CertiUrl"))
//                .build();
//        logger.info(team1.toString());

          logger.info(team.toString());
//        AmazonS3Util.uploadFile("라피치",request.getParameter("pledgePhoto"));
        AmazonS3Util.uploadFile("라피치",team.getPledge());
        String url= AmazonS3Util.getFileURL("라피치");;

        logger.info(url);

        return "redirect:/candiRegister";
    }

}
