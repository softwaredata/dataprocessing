package net.skhu.api;

import lombok.extern.slf4j.Slf4j;
import net.skhu.aws.AmazonS3Util;
import net.skhu.domain.Candidate;
import net.skhu.domain.Member;
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
import javax.servlet.http.HttpSession;
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

    public CandidateController(final TeamMapper teamMapper, final S3FileUploadService s3FileUploadService, final CandidateMapper candidateMapper) {
        this.teamMapper = teamMapper;
        this.s3FileUploadService = s3FileUploadService;
        this.candidateMapper = candidateMapper;
    }

    @GetMapping("candidateCheck")
    public String candidateCheck(Model model, HttpSession session){
        Member user =(Member)session.getAttribute("user");

        Team team = teamMapper.findTeamMatchId(user.getStudentIdx());
        model.addAttribute("team",team);
        return "candidate/candidateCheck";
    }

    //입후보 등록
    @GetMapping("candiRegister")
    public String createCandidate(HttpSession session){
        Member user =(Member)session.getAttribute("user");

        return "candidate/register";
    }

    @PostMapping("register")
    public void createRegister(@RequestBody Team team, HttpServletResponse response,HttpServletRequest request,HttpSession session) throws IOException {
        Member user =(Member)session.getAttribute("user");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String redirectUrl = request.getRequestURI();

        boolean check=s3FileUploadService.registVaildateCheck(team);
        if(check==false) {
            out.println("정보를 모두 입력하세요");
            out.close();
        }
        else if(s3FileUploadService.alreadyRegistCheck(team)==false){
            out.println("이미 등록된 후보자입니다");
            out.close();
        }
        else {
            s3FileUploadService.registerS3FileUpload(team);
            out.println("후보 등록 신청이 되었습니다. 관리자의 승인을 기다려 주세요");
            out.flush();
            redirectUrl="/main";


        }
        response.sendRedirect(redirectUrl);
    }

}
