package net.skhu.mapper;

import net.skhu.domain.Teams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ElectionResultMapper {



    @Select("select count(*)\n" +
            "from Election e inner join User_to_election u\n" +
            "on e.idx = u.election_idx\n" +
            "where e.type = #{electionidx} and u.abandonment = 1")
    int findByElectionAbandonment(int electionidx);

    @Select("select count(*)\n" +
            "from Election e inner join User_to_election u\n" +
            "on e.idx = u.election_idx\n" +
            "where e.type = #{electionidx} and u.abandonment = 0")
    int findByElectionVote(int electionidx);

    @Select("select u.team_idx idx, count(*) tt\n" +
            "from Election e inner join User_to_election u\n" +
            "on e.idx = u.election_idx\n" +
            "where e.type = #{electionidx} and u.abandonment = 0\n" +
            "group by u.team_idx\n" +
            "order by tt desc\n" +
            "limit 1")
    Teams findByCandidateInformation(int electionidx);

    @Select("select * from Teams where idx = #{idx}")
    Teams findByCandidateImages(Teams idx);

}
