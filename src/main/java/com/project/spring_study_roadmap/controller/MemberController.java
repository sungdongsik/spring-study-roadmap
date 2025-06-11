package com.project.spring_study_roadmap.controller;

import com.project.spring_study_roadmap.domain.Member;
import com.project.spring_study_roadmap.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    // 필드 주입
    //@Autowired
    private final MemberService memberService;

    /*// 비추천
    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }*/

    // 생성자 주입
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String createForm(MemberForm memberForm){
        Member member = new Member();
        member.setName(memberForm.getName());

        System.out.println("member = " + member.getName());

        memberService.join(member);
        return "redirect:/";
    }


    @GetMapping("/members")
    public String list(Model model){
        model.addAttribute("members", memberService.findMembers());
        return "members/memberList";
    }
}
