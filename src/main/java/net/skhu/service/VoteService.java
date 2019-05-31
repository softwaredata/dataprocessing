package net.skhu.service;

import lombok.RequiredArgsConstructor;
import net.skhu.dto.ElectionVoteDate;
import net.skhu.mapper.ElectionMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final ElectionMapper electionMapper;

    void voteCandidate(ElectionVoteDate electionVoteDate) {

        if (isChairpersonTotalStudentVote(electionVoteDate.getType()))
            electionMapper.insertChairpersonTotalStudentVote(electionVoteDate.getName());

        if (isFaciltyRepresentativeVote(electionVoteDate.getType()))
            electionMapper.insertFaciltyRepresentativeVote(electionVoteDate.getName());

        if (isMajorRepresentativeVote(electionVoteDate.getType()))
            electionMapper.insertMajorRepresentativeVote(electionVoteDate.getName());
    }

    private boolean isChairpersonTotalStudentVote(int type) {
        return type == 1;
    }

    private boolean isFaciltyRepresentativeVote(int type) {
        return type == 2;
    }

    private boolean isMajorRepresentativeVote(int type) {
        return type == 3;
    }
}
