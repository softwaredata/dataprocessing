package net.skhu.mapper;

import net.skhu.domain.Member;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE idx = {id}")
    Member findById(@Param("id") int idx);

    @Insert("insert into Member(name, studentIdx, department, password, email, type)" +
            "values(#{name}, #{studentIdx}, #{department}, #{password}, #{email}, #{type})")
    void insertUsers(Member member);

    @Select("select * from Member where studentIdx = #{studentIdx} and email = #{email}")
    Member findUser(Member user);


    @Update("update Member set password = #{password} where studentIdx ={studentIdx}")
    void updatePws(Member member);
}
