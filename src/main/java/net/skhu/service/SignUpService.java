package net.skhu.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.mapper.UserMapper;
import net.skhu.domain.Users;
import net.skhu.dto.SignUpRequestDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignUpService {

    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public Users signUp(SignUpRequestDto signUpRequestDto) {

        Users users = Users.builder()
                .name(signUpRequestDto.getName())
                .studentIdx(signUpRequestDto.getStudentIdx())
                .department(signUpRequestDto.getDepartment())
                .password(passwordEncoder.encode(signUpRequestDto.getPassword()))
                .email(signUpRequestDto.getEmail())
                .type(signUpRequestDto.getType())
                .build();

        userMapper.insertUsers(users);
       return users;
    }



}
