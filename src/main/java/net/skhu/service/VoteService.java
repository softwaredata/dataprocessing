package net.skhu.service;

import lombok.RequiredArgsConstructor;
import net.skhu.dto.ElectionVoteDate;
import net.skhu.dto.SelectAnElectionType;
import net.skhu.mapper.ElectionMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final ElectionMapper electionMapper;

    public void voteCandidate(ElectionVoteDate electionVoteDate) {

        if (isChairpersonTotalStudentVote(electionVoteDate.getType()))
            electionMapper.insertChairpersonTotalStudentVote(electionVoteDate.getIdx());

        if (isFaciltyRepresentativeVote(electionVoteDate.getType()))
            electionMapper.insertFaciltyRepresentativeVote(electionVoteDate.getIdx());

        if (isMajorRepresentativeVote(electionVoteDate.getType()))
            electionMapper.insertMajorRepresentativeVote(electionVoteDate.getIdx());
    }

    private boolean isChairpersonTotalStudentVote(int type) {
        return type == SelectAnElectionType.CHAIRPERSON_OF_THE_TOTAL_STUDENT.getType();
    }

    private boolean isFaciltyRepresentativeVote(int type) {
        return type == SelectAnElectionType.FACULTY_REPRESENTATIVE.getType();
    }

    private boolean isMajorRepresentativeVote(int type) {
        return type == SelectAnElectionType.MAJOR_REPRESENTATIVE.getType();
    }
}
