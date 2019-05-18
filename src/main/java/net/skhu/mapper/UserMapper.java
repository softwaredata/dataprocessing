package net.skhu.mapper;

import net.skhu.domain.Users;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE idx = {id}")
    Users findById(@Param("id") int idx);

    @Insert("insert into Users(name, studentIdx, department, password, email, type)" +
            "values(#{name}, #{studentIdx}, #{department}, #{password}, #{email}, #{type})")
    void insertUsers(Users users);

    @Select("select * from Users where studentIdx = #{studentIdx} and email = #{email}")
    Users findUser(Users user);

    @Update("update Users set password = #{password} where studentIdx ={studentIdx}")
    void updatePws(Users users);
}
