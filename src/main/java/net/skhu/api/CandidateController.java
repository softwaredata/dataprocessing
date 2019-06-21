package net.skhu.api;

import com.sun.media.jfxmediaimpl.MediaUtils;
import lombok.extern.slf4j.Slf4j;
import net.skhu.aws.AmazonS3Util;
import net.skhu.domain.Team;
import net.skhu.mapper.TeamMapper;
import net.skhu.service.S3FileUploadService;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public String teamRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {



        boolean check=s3FileUploadService.registVaildateCheck(request,response);


        if(check==false)
            return "candidate/candidateRegister";
        else
            return "redirect:/candiRegister";
    }

}
