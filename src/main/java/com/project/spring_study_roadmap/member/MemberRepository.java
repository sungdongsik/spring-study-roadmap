package com.project.spring_study_roadmap.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
