package net.skhu.Mapper;

import net.skhu.domain.Users;
import net.skhu.dto.PwsReq;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Insert("insert into Users(name, studentIdx, department, password, email, type)" +
            "values(#{name}, #{studentIdx}, #{department}, #{password}, #{email}, #{type})")
    void insertUsers(Users users);

    @Select("select * from Users where studentIdx = #{studentIdx} and email = #{email}")
    Users findUser(Users user);


    @Update("update Users set password = #{password} where studentIdx ={studentIdx}")
    void updatePws(Users users);
}
