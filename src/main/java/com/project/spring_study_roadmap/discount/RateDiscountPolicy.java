package com.project.spring_study_roadmap.discount;

import com.project.spring_study_roadmap.member.Grade;
import com.project.spring_study_roadmap.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else  {
            return 0;
        }

    }
}
