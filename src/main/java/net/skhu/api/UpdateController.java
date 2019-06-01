package net.skhu.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Member;
import net.skhu.dto.PwsReq;
import net.skhu.dto.SignUpRequest;
import net.skhu.mapper.UserMapper;
import net.skhu.service.PwsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class UpdateController {

    private final PwsService pwsService;

    private final UserMapper userMapper;

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
    @GetMapping("mypage")
    public String mypage(Model model,SignUpRequest mypage){

    	
    	Member member = userMapper.findByStuId(201632009);
        model.addAttribute("member",member);
    	
        return "users/mypage";
    }
    
    @PostMapping("mypage")
    public String mypage(Model model,Member member){

    	
    	userMapper.updateInfo(member);
        model.addAttribute("member",member);
        return "redirect:/mypage";
    }
    


}
