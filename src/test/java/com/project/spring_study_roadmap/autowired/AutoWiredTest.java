package com.project.spring_study_roadmap.autowired;

import com.project.spring_study_roadmap.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void autowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }


    static class TestBean{

        @Autowired(required = false)
        public void setNoBean1(Member member){
            System.out.println("member = " + member);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member){
            System.out.println("member = " + member);
        }

        @Autowired
        public void setNoBean3(Optional<Member> member){
            System.out.println("member = " + member);
        }




    }
}
