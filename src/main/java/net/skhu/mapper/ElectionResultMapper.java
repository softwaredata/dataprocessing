package net.skhu.mapper;

import net.skhu.domain.Teams;
import net.skhu.domain.UserToElection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ElectionResultMapper {


    @Select("select count(*) 총기권투표수 from User_to_election where election_idx = #{electionidx} and abandonment = 1")
    int findByElectionAbandonment(UserToElection userToElection);

    @Select("select count(*) 총투표수 from User_to_election where election_idx = #{electionidx} and abandonment = 0")
    int findByElectionVote(UserToElection userToElection);

    @Select("select * from Teams where idx = #{idx}")
    Teams findByCandidateImages(int idx);

}
