package com.project.spring_study_roadmap.test;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
public class User {

    @Id
    @Column(name = "HOST_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private int age;

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    @Builder
    public User(Long userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }

}
