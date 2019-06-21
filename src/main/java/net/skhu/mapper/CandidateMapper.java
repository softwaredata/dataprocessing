package net.skhu.mapper;

import net.skhu.domain.Candidate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CandidateMapper {

    @Insert("insert into Candidates (idx, profile_url)" +
     "values (#{idx}, #{profileUrl})" )
    void insertCandidate(Candidate candidate);

}
