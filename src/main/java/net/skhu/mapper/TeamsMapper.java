package net.skhu.mapper;

import net.skhu.domain.Candidate;
import net.skhu.domain.Teams;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TeamsMapper {

    @Select("select * from Teams where type_chk = 0")
    List<Teams> findByTeams();


    @Select("select c.*\n" +
            "from Teams t inner join Candidates c\n" +
            "on t.candidate1_idx = c.idx\n" +
            "where t.idx = #{idx}")
    Candidate findByCandidateTeam(int idx);


    @Select("select c.*\n" +
            "from Teams t inner join Candidates c\n" +
            "on t.candidate2_idx = c.idx\n" +
            "where t.idx = #{idx}")
    Candidate findBySubCandidateTeam(int idx);

    @Select("select * from Teams where idx = ${idx}")
    Teams findByTeam(int idx);

    @Delete("delete from Teams where idx = #{idx}")
    void deleteTeams(int idx);

    @Update("update Teams set type_chk = 1 where idx = #{idx}")
    void updateTeams(int idx);
}
