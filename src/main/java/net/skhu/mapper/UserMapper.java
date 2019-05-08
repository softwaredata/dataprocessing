package net.skhu.mapper;

import net.skhu.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("insert into Users(name, studentIdx, department, password, email, type)" +
            "values(#{name}, #{studentIdx}, #{department}, #{password}, #{email}, #{type})")
    void insertUsers(Users users);
}
