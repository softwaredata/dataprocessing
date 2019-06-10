package net.skhu.mapper;

import net.skhu.domain.Election;
import net.skhu.dto.ElectionVoteDate;
import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper
public interface ElectionMapper {

    @Select("select * from Election where name = #{name} and type = #{type}")
    ElectionVoteDate findByVoteDate(ElectionVoteDate electionVoteDate);

    @Select("select * from Election where type = #{type}")
    ElectionVoteDate findByVoteDate1(int type);


}
