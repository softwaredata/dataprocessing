package net.skhu.service;

import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.ElectionVoteDate;
import net.skhu.dto.SelectAnElectionType;
import net.skhu.mapper.ElectionMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class VoteServiceTest {

    @Autowired
    private ElectionMapper electionMapper;

    private ElectionVoteDate electionVoteDate;

    @Test
    void 학생이_총학선거_투표하기() {
        electionVoteDate = ElectionVoteDate.builder()
                .name(1)
                .type(SelectAnElectionType.CHAIRPERSON_OF_THE_TOTAL_STUDENT.getType())
                .build();

//        assertEquals(2,electionMapper.findByVoteDate(electionVoteDate).getCollegeElectionTotalVote()+1);
    }

    @Test
    void 학생이_학부_투표하기() {
        electionVoteDate = ElectionVoteDate.builder()
                .name(1)
                .type(SelectAnElectionType.FACULTY_REPRESENTATIVE.getType())
                .build();

//        assertEquals(1,electionMapper.findByVoteDate(electionVoteDate).getUnderGraduateElectionTotalVote()+1);
    }

    @Test
    void 학생이_전공_투표하기() {
        electionVoteDate = ElectionVoteDate.builder()
                .name(1)
                .type(SelectAnElectionType.MAJOR_REPRESENTATIVE.getType())
                .build();

//        assertEquals(1,electionMapper.findByVoteDate(electionVoteDate).getMajorElectionTotalVote()+1);
    }
}