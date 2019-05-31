package net.skhu.extend.voteimplement;

import lombok.RequiredArgsConstructor;
import net.skhu.mapper.ElectionMapper;

@RequiredArgsConstructor
public class FaciltyRepresentativeVote implements Vote {

    private final ElectionMapper electionMapper;

    @Override
    public void chooseCandidate(int name) {
        electionMapper.insertFaciltyRepresentativeVote(name);
    }

}
