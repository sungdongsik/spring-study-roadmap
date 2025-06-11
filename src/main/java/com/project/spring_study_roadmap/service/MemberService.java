package com.project.spring_study_roadmap.service;

import com.project.spring_study_roadmap.domain.Member;
import com.project.spring_study_roadmap.repository.MemberRepository;
import com.project.spring_study_roadmap.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * @param member
     * @return
     * 회원 가입
     */
    public Long join(Member member){
        // 같은 이름이 있는  중복 회원X
        validateDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 전체 회원 검색
     * @return
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException(m.getName() + " 이미 존재하는 회원합니다.");
                });
    }
}
