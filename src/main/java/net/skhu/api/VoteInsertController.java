package net.skhu.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteInsertController {

    @GetMapping("test")
    public String test() {
        return "배포테스트";
    }

}
