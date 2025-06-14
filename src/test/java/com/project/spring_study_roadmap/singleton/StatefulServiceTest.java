package com.project.spring_study_roadmap.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: 사용자A 10000원 주문
        int userA = statefulService1.order("userA", 10000);
        // ThreadB: 사용자B  20000원 주문
        int userB = statefulService2.order("userB", 20000);


        // ThreadA: 사용자A 주문 금액 조회
        /*int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        assertThat(statefulService1.getPrice()).isEqualTo(20000);*/



    }

    static class TestConfig{

        @Bean
        public StatefulService singletonService(){
            return new StatefulService();
        }
    }
}