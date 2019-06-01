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
    void 학생이_총학선거_투표하기() {
        ElectionVoteDate electionVoteDate = ElectionVoteDate.builder()
                .name(1)
                .type(SelectAnElectionType.CHAIRPERSON_OF_THE_TOTAL_STUDENT.getType())
                .build();


    }

}