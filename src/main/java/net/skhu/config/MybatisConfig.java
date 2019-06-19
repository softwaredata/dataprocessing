package net.skhu.config;

import net.skhu.mapper.ElectionMapper;
import net.skhu.mapper.MemberMapper;
import net.skhu.mapper.TeamMapper;
import net.skhu.mapper.UserToElectionMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "net.skhu.mapper")
public class MybatisConfig {

    @Bean
    public ElectionMapper electionMapper(){return electionMapper();}
    @Bean
    public MemberMapper memberMapper(){return memberMapper();}
    @Bean
    public TeamMapper teamMapper(){return teamMapper();}
    @Bean
    public UserToElectionMapper userToElectionMapper(){return userToElectionMapper();}
}
