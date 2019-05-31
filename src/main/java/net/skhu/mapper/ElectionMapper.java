package net.skhu.mapper;

import net.skhu.domain.Election;
import net.skhu.dto.ElectionVoteDate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ElectionMapper {

    @Select("select * from Election where name = #{name} and type = #{type}")
    Election findByVoteDate(ElectionVoteDate electionVoteDate);

    @Insert("update Election set college_election_total_vote = college_election_total_vote+1\n" +
            "where name = #{name}")
    void insertChairpersonTotalStudentVote(int name);

    @Insert("update Election set undergraduate_election_total_vote = undergraduate_election_total_vote+1\n" +
            "where name = #{name}")
    void insertFaciltyRepresentativeVote(int name);

    @Insert("update Election set major_election_total_vote = major_election_total_vote+1\n" +
            "where name = #{name} and type = #{type}")
    void insertMajorRepresentativeVote(int name);
}
