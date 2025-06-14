package com.project.spring_study_roadmap.order;

import com.project.spring_study_roadmap.discount.DiscountPolicy;
import com.project.spring_study_roadmap.discount.FixDiscountPolicy;
import com.project.spring_study_roadmap.discount.RateDiscountPolicy;
import com.project.spring_study_roadmap.member.Member;
import com.project.spring_study_roadmap.member.MemberRepository;
import com.project.spring_study_roadmap.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itermPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itermPrice);


        return new Order(memberId, itemName, itermPrice, discountPrice);
    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
