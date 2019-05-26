package net.skhu.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.service.ElectionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




/**
 * Created by bomi on 2019-05-25.
 */

@Slf4j
@AllArgsConstructor
@Controller
public class AdminController {
    final ElectionService electionService;

    @GetMapping("admin/electionManagement")
    public String electionManagement(Model model) {


        return  "admin/electionManagement";
    }

    @PostMapping("admin/electionManagement")
    public String electionManagement() {
        return "admin/electionManagement";
    }
}
