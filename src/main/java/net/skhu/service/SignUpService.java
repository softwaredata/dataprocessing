package net.skhu.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.domain.Users;
import net.skhu.dto.SignUpRequestDto;
import net.skhu.repository.SignUpRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignUpService {

    private final SignUpRepository signUpRepository;

    public Users signUp(SignUpRequestDto signUpRequestDto) {

        Users users = Users.builder()
                .name(signUpRequestDto.getName())
                .studentIdx(signUpRequestDto.getStudentIdx())
                .department(signUpRequestDto.getDepartment())
                .password(signUpRequestDto.getPassword())
                .email(signUpRequestDto.getEmail())
                .type(signUpRequestDto.getType())
                .build();

        return signUpRepository.save(users);
    }
}
