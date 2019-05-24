package net.skhu.mapper;

import net.skhu.domain.Election;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by bomi on 2019-05-15.
 */

@Mapper
public interface ElectionMapper {
    @Select("SELECT name, vote_start_date, vote_end_date, type, reg_start_date, reg_end_date " +
            "FROM election WHERE vote_end_date >= #{now}")
    List<Election> findElections(@Param("now")final LocalDateTime dateTime);

    @Select("SELECT name, vote_start_date, vote_end_date, type, reg_start_date, reg_end_date " +
            "FROM election WHERE name = #{name}")
    Election findByName(@Param("name") final String name);

    @Insert("INSERT INTO election(name, vote_start_date, vote_end_date, type, reg_start_date, reg_end_date) " +
            "VALUES(#{name}, #{voteStartDate}, #{voteEndDate}, #{type}, #{regDateDate}, #{redEndDate})")
    void create(final Election election);

    @Update("UPDATE election SET name = #{name}, vote_start_date = #{voteStartDate}, vote_end_date = #{voteEndDate}" +
            "type = #{type}, reg_start_date = #{regStartDate}, reg_end_date = #{regEndDate}" +
            "WHERE idx = #{idx}")
    void update(final Election election);
}
