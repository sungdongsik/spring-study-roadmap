package com.project.spring_study_roadmap.domain;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class Address {

    private String city;

    private String distance;

    private String zipCode;


    @Builder
    public Address(String city, String distance, String zipCode) {
        this.city = city;
        this.distance = distance;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getDistance() {
        return distance;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(distance, address.distance) && Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, distance, zipCode);
    }
}
