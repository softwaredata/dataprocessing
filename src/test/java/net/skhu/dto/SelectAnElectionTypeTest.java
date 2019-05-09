package net.skhu.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SelectAnElectionTypeTest {

    @BeforeEach
    void setup() {

    }

    @Test
    @DisplayName("선거 기간이 아니면 투표 못하게 막기")
    void duringElectionPeriodOrPreventVoting() {
        
    }

}