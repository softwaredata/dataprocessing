package net.skhu.mapper;

import net.skhu.dto.Election;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Created by bomi on 2019-05-15.
 */

@Mapper
public interface ElectionMapper {
    @Insert("INSERT INTO election(name, vote_start_date, vote_end_date, type, reg_start_date, reg_end_date)" +
            "VALUES(#{name}, #{voteStartDate}, #{voteEndDate}, #{type}, #{regDateDate}, #{redEndDate})")
    void createElection(final Election election);

    @Update("UPDATE election SET name = #{name}, vote_start_date = #{voteStartDate}, vote_end_date = #{voteEndDate}" +
            "type = #{type}, reg_start_date = #{regStartDate}, reg_end_date = #{regEndDate}" +
            "WHERE idx = #{idx}")
    void updateElection(final Election election);
}
