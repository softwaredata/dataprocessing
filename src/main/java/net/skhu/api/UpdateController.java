package net.skhu.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Member;
import net.skhu.dto.PwsReq;
import net.skhu.mapper.MemberMapper;
import net.skhu.service.PwsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequestMapping("/")
public class UpdateController {

    private final PwsService pwsService;

    private final MemberMapper memberMapper;

    private final PasswordEncoder passwordEncoder;

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
    @ResponseBody
    public void updatePws(HttpServletRequest request, HttpServletResponse response) throws Exception{
        PwsReq pwsReq =PwsReq.builder()
                .id(Integer.parseInt(request.getParameter("id")))
                .email(request.getParameter("email"))
                .build();
        log.info(pwsReq.toString());
        pwsService.find_psw(response,pwsReq);

    }
    
    
    //개인정보 수정 

    @GetMapping("mypage")
    public String mypage(Model model){

        log.info("ㅋㅋㅋ");
    	Member member = memberMapper.findByStuId(201632009);
        model.addAttribute("member",member);
    	
        return "users/mypage";
    }


    @RequestMapping(value = "/mypage" ,  method = RequestMethod.POST)

    public String updateMypage(Member member,  RedirectAttributes redirectAttributes, Model model){

        log.info(member.toString());

        member.setPassword(passwordEncoder.encode(member.getPassword()));

    	memberMapper.updateInfo(member);
        //redirectAttributes.addAttribute("member",member);
        log.info(member.toString());
        model.addAttribute("member", member);
        return "redirect:/mypage";

    }
    


}
