package com.project.spring_study_roadmap;

import com.project.spring_study_roadmap.repository.MemberRepository;
import com.project.spring_study_roadmap.repository.MemoryMemberRepository;
import com.project.spring_study_roadmap.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
