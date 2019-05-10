package net.skhu.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.LoginRequest;
import net.skhu.service.LoginService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bomi on 2019-05-03.
 */

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class LoginController {
    private final LoginService loginService;

    @PostMapping("")
    public ResponseEntity login(@RequestBody LoginRequest loginReq) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping({"", "login"})
    public String login() {
        return "login";
    }

}
