package net.skhu.api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Member;
import net.skhu.dto.PwsReq;
import net.skhu.dto.SignUpRequest;
import net.skhu.mapper.MemberMapper;
import net.skhu.service.PwsService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
    public void updatePws(PwsReq pwsReq, HttpServletResponse response) throws Exception{

        pwsService.find_psw(response,pwsReq);

    }
    
    
    //개인정보 수정 
    @RequestMapping("mypage")
    public String mypage(Model model){

    	
    	Member member = memberMapper.findByStuId(201632009);
        model.addAttribute("member",member);
    	
        return "users/mypage";
    }

    @Transactional
    @RequestMapping(value = "mypage", method = RequestMethod.POST)//학과 나중에 고쳐야함
    public String mypage(@ModelAttribute Object obj, RedirectAttributes redirectAttributes){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(obj.get("studentIdx"));
        Member member = new Member();
        member.setStudentIdx();
        logger.info(member.getStudentIdx()+"");
        logger.info(member.getEmail());
    	memberMapper.updateInfo(member);
        redirectAttributes.addAttribute("member",member);
        return "redirect:/mypage";
    }
    


}
