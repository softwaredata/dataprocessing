package net.skhu.mapper;

import net.skhu.domain.Election;
import net.skhu.dto.ElectionVoteDate;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by bomi on 2019-05-15.
 */

@Mapper
public interface ElectionMapper {
    @Select("SELECT name, vote_start_date, vote_end_date, type, reg_start_date, reg_end_date " +
            "FROM Election")
    List<Election> findElections();

    @Select("SELECT name, vote_start_date, vote_end_date, type, reg_start_date, reg_end_date " +
            "FROM Election WHERE type = #{type}")
    Election findByName(@Param("type") final int type);

    @Insert("INSERT INTO Election(name, vote_start_date, vote_end_date, type, reg_start_date, reg_end_date) " +
            "VALUES(#{name}, #{voteStartDate}, #{voteEndDate}, #{type}, #{regDateDate}, #{redEndDate})")
    void create(final Election election);

    @Update("UPDATE Election SET name = #{name}, vote_start_date = #{voteStartDate}, vote_end_date = #{voteEndDate}" +
            "type = #{type}, reg_start_date = #{regStartDate}, reg_end_date = #{regEndDate}" +
            "WHERE idx = #{idx}")
    void update(final Election election);

    @Select("select * from Election where name = #{name} and type = #{type}")
    ElectionVoteDate findByVoteDate(ElectionVoteDate electionVoteDate);

}
