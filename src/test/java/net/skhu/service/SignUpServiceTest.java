package net.skhu.service;

import net.skhu.domain.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SignUpServiceTest {

    private  PasswordEncoder passwordEncoder;

    @BeforeEach
    void setup() throws Exception {
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Test
    @DisplayName("Users 값 없을때")
    void throwsExceptionWhenUserInsert () {

        Users users = Users.builder()
                .name("test")
                .studentIdx(20111111)
                .password(passwordEncoder.encode("test"))
                .email("test@test.com")
                .type(1)
                .build();


    }
}
