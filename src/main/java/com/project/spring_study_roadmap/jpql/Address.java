package com.project.spring_study_roadmap.jpql;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String city;

    private String street;

    private String zipcode;
}
