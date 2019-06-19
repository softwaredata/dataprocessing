package net.skhu.api;


import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Member;
import net.skhu.dto.PwsReq;
import net.skhu.dto.SignUpRequest;
import net.skhu.mapper.MemberMapper;
import net.skhu.service.PwsService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequestMapping("/")
public class UpdateController {

    private final PwsService pwsService;

    private final MemberMapper memberMapper;

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateController.class);

    public UpdateController(final PwsService pwsService,final MemberMapper memberMapper) {
        this.pwsService = pwsService;
        this.memberMapper = memberMapper;
    }

    @GetMapping("findPws")
    public String findPws(Model model,PwsReq pwsReq){

        model.addAttribute("pwsReq",pwsReq);
        return "users/findPws";
    }

    @PostMapping("find_pws")
    @ResponseBody
    public void updatePws(@RequestBody PwsReq pwsReq, HttpServletResponse response) throws Exception{

        logger.info(pwsReq.toString());
        pwsService.find_psw(response,pwsReq);

    }
    
    
    //개인정보 수정 
    @GetMapping("mypage")
    public String mypage(Model model){

    	
    	Member member = memberMapper.findByStuId(201632009);
        model.addAttribute("member",member);
    	
        return "users/mypage";
    }
    
    @PostMapping("mypage")
    public String mypage(Model model,Member member){
        logger.info(member.toString());
    	memberMapper.updateInfo(member);
        model.addAttribute("member",member);
        return "redirect:/mypage";
    }
    


}
