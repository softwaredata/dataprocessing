package net.skhu.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PasswordTest {

    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setup() throws Exception {
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Test
    @DisplayName("스프링 시큐리티 인코더 테스트")
    public void passwordEncode() {
        String passwordTest = "test";
        assertTrue(passwordEncoder.matches(passwordTest,passwordEncoder.encode(passwordTest)));
    }
}
