package com.project.spring_study_roadmap.order;

import com.project.spring_study_roadmap.annotation.MainDiscountPolicy;
import com.project.spring_study_roadmap.discount.DiscountPolicy;
import com.project.spring_study_roadmap.discount.FixDiscountPolicy;
import com.project.spring_study_roadmap.discount.RateDiscountPolicy;
import com.project.spring_study_roadmap.member.Member;
import com.project.spring_study_roadmap.member.MemberRepository;
import com.project.spring_study_roadmap.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    //@Autowired
    private final MemberRepository memberRepository;
    //@Autowired
    private final DiscountPolicy discountPolicy;

    // 수정자 주입
    /*@Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }*/


    // 일반 메서드 주입
    /*@Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy  = discountPolicy;
    }*/

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        System.out.println("memberRepository = " + memberRepository);
        System.out.println("discountPolicy = " + discountPolicy);
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
