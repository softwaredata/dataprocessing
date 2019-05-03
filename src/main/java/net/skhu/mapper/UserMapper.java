package net.skhu.mapper;

import net.skhu.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE idx = {id}")
    Users findById(@Param("id") int idx);

    @Insert("insert into Users(name, studentIdx, department, password, email, type)" +
            "values(#{name}, #{studentIdx}, #{department}, #{password}, #{email}, #{type})")
    void insertUsers(Users users);
}
