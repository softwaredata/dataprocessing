package net.skhu.mapper;

import net.skhu.domain.Team;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeamMapper {
    @Select("select * from Teams where election_Idx = #{electionIdx}")
    List<Team> findTeams(int electionIdx);

    @Select("select * from Teams where idx = #{teamNum}")
    Team findTeamOfOne(int teamNum);

    @Select("select t.*, m1.name name1, m2.name name2\n" +
            "from Teams t left join Member m1\n" +
            "on t.candidate1_idx = m1.studentIdx\n" +
            "left join Member m2\n" +
            "on t.candidate2_idx =m2.studentIdx\n" +
            "where t.idx = #{teamNum}")
    Team findTeamOfDetail(int teamNum);
}
