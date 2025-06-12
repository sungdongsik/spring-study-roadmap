package com.project.spring_study_roadmap;

import com.project.spring_study_roadmap.member.Grade;
import com.project.spring_study_roadmap.member.Member;
import com.project.spring_study_roadmap.member.MemberService;
import com.project.spring_study_roadmap.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        memberService.join(new Member(1L, "java", Grade.VIP));


        Member member = memberService.findMember(1L);
        System.out.println("member = " + member);
    }
}
