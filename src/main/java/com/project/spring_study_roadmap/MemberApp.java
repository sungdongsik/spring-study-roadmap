package com.project.spring_study_roadmap;

import com.project.spring_study_roadmap.member.Grade;
import com.project.spring_study_roadmap.member.Member;
import com.project.spring_study_roadmap.member.MemberService;
import com.project.spring_study_roadmap.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        /*AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        memberService.join(new Member(1L, "java", Grade.VIP));


        Member member = memberService.findMember(1L);
        System.out.println("member = " + member);
    }
}
