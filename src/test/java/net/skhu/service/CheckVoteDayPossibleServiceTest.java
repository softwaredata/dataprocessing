package net.skhu.service;

import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.ElectionVoteDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class CheckVoteDayPossibleServiceTest {

    ElectionVoteDate electionVoteDate;

    @BeforeEach
    void 디비에서_투표기간_가져오기() {
        electionVoteDate = ElectionVoteDate.builder()
                .voteStartDate(LocalDate.of(2019,5,10))
                .voteEndDate(LocalDate.of(2019,5,14))
                .build();
    }

    @Test
    void 현재날짜가_종료기간일때 (){
        LocalDate now = LocalDate.of(2019,5,14);
        assertTrue(now.isEqual(electionVoteDate.getVoteEndDate()));
    }

    @Test
    void 현재날짜가_시작날짜와_종료날짜_안에존재하는지_확인(){
        LocalDate now = LocalDate.of(2019,5,12);
        assertTrue(electionVoteDate.getVoteStartDate().isBefore(now) && electionVoteDate.getVoteEndDate().isAfter(now));
    }

    @Test
    void 현재날짜가_투표시작기간일때() {
        LocalDate now = LocalDate.of(2019,5,10);
        assertTrue(now.isEqual(electionVoteDate.getVoteStartDate()));
    }

}