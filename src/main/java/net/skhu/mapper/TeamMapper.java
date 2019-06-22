package net.skhu.mapper;

import net.skhu.domain.Team;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeamMapper {
    @Select("select * from Teams where election_Idx = #{electionIdx} and type_chk =1")
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

    @Insert("insert into Teams(name, candidate1_idx, candidate2_idx, pledge, recco_photo_url, electioneering_file_url, team_photo_url,\n" +
            "oath_photo_url, election_idx, candidate1_certi_url, candidate2_certi_url,type_chk)" +
            " values(#{name}, #{candidate1idx}, #{candidate2idx}, #{pledge}, #{reccoPhotoUrl}, #{electioneeringFileUrl}, #{teamPhotoUrl}," +
            " #{oathPhotoUrl}, #{electionIdx}, #{candidate1CertiUrl}, #{candidate2CertiUrl},#{typeChk})")
    void insertTeam(Team team);


    @Select("select * from Teams where candidate1_idx = #{candidateIdx} or candidate2_idx =#{candidateIdx}")
    Team findTeamMatchId(int candidateIdx);


    @Select("select t.idx,t.name,t.candidate1_idx,t.candidate2_idx, c1.profile_url profileUrl1, c2.profile_url profileUrl2\n" +
            "from Teams t left join Candidates c1\n" +
            "on t.candidate1_idx = c1.idx\n" +
            "left join Candidates c2\n" +
            "on t.candidate2_idx =c2.idx\n" +
            "where t.idx=  #{teamNum}")
    Team findTeamForCandiImg(int teamNum);

    @Select("select count(*) from Teams where candidate1_idx =#{candidate1idx} or candidate2_idx=#{candidate2idx}")
    int registPossible(Team team);
}
