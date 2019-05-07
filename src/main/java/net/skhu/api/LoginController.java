package net.skhu.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.LoginReq;
import net.skhu.service.LoginService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bomi on 2019-05-03.
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class LoginController {
    private final LoginService loginService;

    @PostMapping("")
    public ResponseEntity login(@RequestBody LoginReq loginReq) {
        return new ResponseEntity(HttpStatus.OK);
    }

}
