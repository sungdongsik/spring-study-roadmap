package com.project.spring_study_roadmap.member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
