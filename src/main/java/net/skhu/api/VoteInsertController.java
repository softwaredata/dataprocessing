package net.skhu.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Member;
import net.skhu.dto.SignUpRequestDto;
import net.skhu.service.SignUpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class VoteInsertController {

    private final SignUpService signUpService;

    @PostMapping("/api/v1/signUp")
    public ResponseEntity<Member> createAccount(@Valid @RequestBody SignUpRequestDto signUpRequestDto) {
        Member user = signUpService.signUp(signUpRequestDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
