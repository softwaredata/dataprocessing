package net.skhu.dto;

import net.skhu.domain.Election;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SelectAnElectionTypeTest {

    private Election election;

    @BeforeEach
    void setup() throws Exception {
        election = Election.builder()
                .voteStartDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-09"))
                .voteEndDate(new SimpleDateFormat("yyyy-MM-dd").parse("2019-05-10") )
                .build();
    }

    @Test
    @DisplayName("선거 기간에 들어 갈 수 있는지 확인")
    void  enterElectionPeriod(){
        int voteStartCompare = election.getVoteStartDate().compareTo(new Date());
        int voteEndCompare = election.getVoteEndDate().compareTo(new Date());

        assertTrue(voteStartCompare <= 0 && voteEndCompare >= 0 );
    }

}