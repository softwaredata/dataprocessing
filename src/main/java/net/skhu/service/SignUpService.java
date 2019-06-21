package net.skhu.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Member;
import net.skhu.dto.SignUpRequest;
import net.skhu.mapper.MemberMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignUpService {

    private final PasswordEncoder passwordEncoder;
    private final MemberMapper memberMapper;

    public Member signUp(SignUpRequest signUpRequestDto) {

        Member member = Member.builder()
                .name(signUpRequestDto.getName())
                .studentIdx(signUpRequestDto.getStudentIdx())
                .department(signUpRequestDto.getDepartment())
                .password(passwordEncoder.encode(signUpRequestDto.getPassword1()))
                .email(signUpRequestDto.getEmail())
                .type(0)
                .build();


        memberMapper.insertUsers(member);
       return member;
    }



}
