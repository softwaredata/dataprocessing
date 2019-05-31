package net.skhu.dto;

import lombok.RequiredArgsConstructor;
import net.skhu.domain.Election;
import net.skhu.extend.Vote;
import net.skhu.mapper.ElectionMapper;

@RequiredArgsConstructor
public class ChairpersonTotalStudentVote implements Vote {

    private final ElectionMapper electionMapper;

    @Override
    public void chooseCandidate(Election election) {
        electionMapper.insertChairpersonTotalStudentVote(election);
    }

}
