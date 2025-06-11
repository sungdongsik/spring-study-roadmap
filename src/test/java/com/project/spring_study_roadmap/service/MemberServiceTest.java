package com.project.spring_study_roadmap.service;

import com.project.spring_study_roadmap.domain.Member;
import com.project.spring_study_roadmap.repository.MemberRepository;
import com.project.spring_study_roadmap.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;
    @BeforeEach
    public void beforeEach(){
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }

    // 회원가입
    @Test
    void join() {
        // given 임무
        Member member = new Member();
        member.setName("hello");

        // when 실행
        Long saveId = memberService.join(member);

        // then 결과
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        // given
        Member member = new Member();
        member.setName("spring");

        Member member1 = new Member();
        member1.setName("spring");

        // when
        memberService.join(member);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member1));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}