package net.skhu.mapper;

import net.skhu.dto.ElectionVoteDate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ElectionMapper {

    @Select("select * from Election where name = #{name} and type = #{type}")
    ElectionVoteDate findByVoteDate(ElectionVoteDate electionVoteDate);

}
