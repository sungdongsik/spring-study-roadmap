package com.project.spring_study_roadmap.order;

import com.project.spring_study_roadmap.AppConfig;
import com.project.spring_study_roadmap.discount.FixDiscountPolicy;
import com.project.spring_study_roadmap.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 1000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    void fieldInjectionTest(){
        /*OrderServiceImpl orderService1 = new OrderServiceImpl();
        *//*orderService1.setMemberRepository(new MemoryMemberRepository());
        orderService1.setDiscountPolicy(new FixDiscountPolicy());*//*

        orderService1.createOrder(1L, "memberA", 10000);*/
    }
}