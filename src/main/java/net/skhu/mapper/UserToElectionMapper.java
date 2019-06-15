package net.skhu.mapper;

import net.skhu.domain.Election;
import net.skhu.domain.UserToElection;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserToElectionMapper {
    @Select("")
    List<UserToElection> findUserToElecton();

    @Select("select count(*) from User_to_election\n" +
            "where student_idx = #{studentidx} and election_idx = #{electionidx}")
    int findMemberPossibleVote(UserToElection userToElection);

    @Insert("insert into User_to_election (student_idx,election_idx,team_idx,abandonment) values (#{studentidx},#{electionidx},#{teamidx},#{abandonment})")
    void goToVote(UserToElection userToElection);

}
