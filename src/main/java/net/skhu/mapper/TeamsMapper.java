package net.skhu.mapper;

import net.skhu.domain.Teams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeamsMapper {

    //TODO camel로 바꾸기
    @Select("select * from Teams where type_chk = 0")
    List<Teams> findByTeams();
}
