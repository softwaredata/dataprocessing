package net.skhu.api;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.PwsReq;
import net.skhu.service.PwsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/")
public class UpdateController {

    private PwsService pwsService;

    @GetMapping("findPws")
    public String findPws(Model model,PwsReq pwsReq){

        model.addAttribute("pwsReq",pwsReq);
        return "users/findPws";
    }

    @PostMapping("find_pws")
    public void updatePws(PwsReq pwsReq, HttpServletResponse response) throws Exception{

        pwsService.find_psw(response,pwsReq);

    }


}
