package net.skhu.api;


import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Member;
import net.skhu.dto.PwsReq;
import net.skhu.mapper.MemberMapper;
import net.skhu.service.PwsService;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequestMapping("/")
public class UpdateController {

    private final PwsService pwsService;

    private final MemberMapper memberMapper;

    private final PasswordEncoder passwordEncoder;

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(UpdateController.class);

    public UpdateController(final PwsService pwsService, final MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
        this.pwsService = pwsService;
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("findPws")
    public String findPws(Model model,PwsReq pwsReq){

        model.addAttribute("pwsReq",pwsReq);
        return "users/findPws";
    }

    @PostMapping("find_pws")
    public void updatePws(PwsReq pwsReq, HttpServletResponse response) throws Exception{

        pwsService.find_psw(response,pwsReq);

    }
    
    
    //개인정보 수정 
    @RequestMapping(value = "/mypage" ,  method = RequestMethod.GET)
    public String mypage(Model model){

    	
    	Member member = memberMapper.findByStuId(201632009);
        model.addAttribute("member",member);
    	
        return "users/mypage";
    }

    @Transactional
    @RequestMapping(value = "/mypage" ,  method = RequestMethod.POST)

    public String updateMypage(Member member,  RedirectAttributes redirectAttributes){

        logger.info(member.toString());

        member.setPassword(passwordEncoder.encode(member.getPassword()));

    	memberMapper.updateInfo(member);
        redirectAttributes.addAttribute("member",member);
        return "redirect:users/mypage";
    }
    


}
