package com.project.spring_study_roadmap;

import com.project.spring_study_roadmap.repository.JdbcMemberRepository;
import com.project.spring_study_roadmap.repository.JdbcTemplateMemberRepository;
import com.project.spring_study_roadmap.repository.MemberRepository;
import com.project.spring_study_roadmap.repository.MemoryMemberRepository;
import com.project.spring_study_roadmap.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
