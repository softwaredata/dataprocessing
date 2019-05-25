package net.skhu.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




/**
 * Created by bomi on 2019-05-25.
 */

@Slf4j
@Controller
public class AdminController {

    @GetMapping("admin/electionManagement")
    public String electionManagement() {
        return  "admin/electionManagement";
    }
}
