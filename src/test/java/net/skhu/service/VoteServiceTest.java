package net.skhu.service;

import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.ElectionVoteDate;
import net.skhu.dto.SelectAnElectionType;
import net.skhu.mapper.ElectionMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class VoteServiceTest {

    @Mock
    ElectionMapper electionMapper;

    @Test
    //TODO 1.디비에서 총 투표 가져오기  2.총투표 +1   3.두개 비교 하기
    void 학생이_총학선거_투표하기() {
        ElectionVoteDate electionVoteDate = ElectionVoteDate.builder()
                .name("1대 총학")
                .type(SelectAnElectionType.CHAIRPERSON_OF_THE_TOTAL_STUDENT.getType())
                .build();

        
    }

}