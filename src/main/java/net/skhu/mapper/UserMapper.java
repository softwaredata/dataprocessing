package net.skhu.mapper;

import net.skhu.domain.Users;
import net.skhu.dto.PwsReq;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE idx = {id}")
    Users findById(@Param("id") int idx);

    @Insert("insert into Users(name, studentIdx, department, password, email, type)" +
            "values(#{name}, #{studentIdx}, #{department}, #{password}, #{email}, #{type})")
    void insertUsers(Users users);

    //학번과 이메일이 일치하는 사람이 있는지 조회
    @Select("select count(*) from Users where studentIdx = #{studentIdx} and email = #{email}")
    int findUserMatchEmail(Users user);

    //비밀번호 변경
    @Update("update Users set password = #{password} where studentIdx =#{studentIdx}")
    void updatePws(Users users);

    @Select("select count(*) from Users where studentIdx=#{studentIdx}")
    int findUser(int studentIdx);
}
