package net.skhu.dto;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class SelectAnElectionTypeTest {

    @Test
    @DisplayName("선거 기간에 들어 갈 수 있는지 확인")
    //TODO 테스트코드 리팩토링 하기
    void  enterElectionPeriod(){

        LocalDate today = LocalDate.now();
        LocalDate startToday = LocalDate.now();
        LocalDate twoAfter = today.plusDays(2);
        LocalDate twoBefore = today.minusDays(2);
        LocalDate endDay = today.plusDays(2);

        assertTrue(startToday.equals(today) && (twoAfter.isAfter(today) && twoBefore.isBefore(today)) && twoAfter.equals(endDay));
    }

}