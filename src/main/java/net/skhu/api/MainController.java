package net.skhu.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {

    @GetMapping("main")
    public String main(){


        return "main/main";
    }

    @GetMapping("election/{vote}")
    public String election(Model model, @PathVariable("vote") int vote){
        model.addAttribute("vote",vote);
        return "election/election1";
    }

    @GetMapping("teamDetail/{vote}")
    public String teamDetail(Model model, @PathVariable("vote") int vote){
        model.addAttribute("vote",vote);
        return "election/teamDetail";
    }


}
