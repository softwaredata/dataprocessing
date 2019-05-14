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

    //학번과 이메일이 일치하는 사람이 있는지 조회
    @Select("select count(*) from Member where studentIdx = #{studentIdx} and email = #{email}")
    int findUserMatchEmail(Member user);

    //비밀번호 변경
    @Update("update Member set password = #{password} where studentIdx =#{studentIdx}")
    void updatePws(Member member);

    @Select("select count(*) from Member where studentIdx=#{studentIdx}")
    int findUser(int studentIdx);
}
