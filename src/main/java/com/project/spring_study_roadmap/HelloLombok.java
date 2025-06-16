package com.project.spring_study_roadmap;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;

    private int age;


    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setAge(1);
        helloLombok.setName("A");

        System.out.println("helloLombok = " + helloLombok);
    }
}
