package com.project.spring_study_roadmap;

import com.project.spring_study_roadmap.member.Grade;
import com.project.spring_study_roadmap.member.Member;
import com.project.spring_study_roadmap.member.MemberService;
import com.project.spring_study_roadmap.member.MemberServiceImpl;
import com.project.spring_study_roadmap.order.Order;
import com.project.spring_study_roadmap.order.OrderService;
import com.project.spring_study_roadmap.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        /*AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("itemA = " + order);
        System.out.println("itemA = " + order.calculatePrice());
    }
}
