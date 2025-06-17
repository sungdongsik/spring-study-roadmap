package com.project.spring_study_roadmap.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonTest.class);

        SingletonTest singletonTest1 = ac.getBean(SingletonTest.class);
        SingletonTest singletonTest2 = ac.getBean(SingletonTest.class);
        System.out.println("singletonTest1 = " + singletonTest1);
        System.out.println("singletonTest2 = " + singletonTest2);

        assertThat(singletonTest1).isSameAs(singletonTest2);

        ac.close();
    }

    @Scope("singleton")
    static class SingletonBean{


        @PostConstruct
        public void init(){
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("SingletonBean.destroy");
        }
    }
}
