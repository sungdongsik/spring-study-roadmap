package com.project.spring_study_roadmap;

import com.project.spring_study_roadmap.discount.DiscountPolicy;
import com.project.spring_study_roadmap.discount.FixDiscountPolicy;
import com.project.spring_study_roadmap.discount.RateDiscountPolicy;
import com.project.spring_study_roadmap.member.MemberRepository;
import com.project.spring_study_roadmap.member.MemberService;
import com.project.spring_study_roadmap.member.MemberServiceImpl;
import com.project.spring_study_roadmap.member.MemoryMemberRepository;
import com.project.spring_study_roadmap.order.OrderService;
import com.project.spring_study_roadmap.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
        //return null;
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
