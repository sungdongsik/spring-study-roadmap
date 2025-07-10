package com.project.spring_study_roadmap.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    private String contact;

    private String birth;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city",
                    column=@Column(name="HOME_CITY")
            ),
            @AttributeOverride(name="distance",
                    column=@Column(name="HOME_DISTANCE")
            ),
            @AttributeOverride(name="zipCode",
                    column=@Column(name="HOME_ZIPCODE"))
    })
    private Address homeAddress;

    @AttributeOverrides({
            @AttributeOverride(name="city",
                    column=@Column(name="WORK_CITY")
            ),
            @AttributeOverride(name="distance",
                    column=@Column(name="WORK_DISTANCE")
            ),
            @AttributeOverride(name="zipCode",
                    column=@Column(name="WORK_ZIPCODE"))
    })
    @Embedded
    private Address workAddress;


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "PAST_ADDRESS",
            joinColumns = @JoinColumn(name = "USER_ID"))
    private Set<Address> pastAddress = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getContact() {
        return contact;
    }

    public String getBirth() {
        return birth;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public Set<Address> getPastAddress() {
        return pastAddress;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
        order.addUser(this);
    }

    @Builder
    public User(Long id, String contact, String birth, Address homeAddress, Address workAddress) {
        this.id = id;
        this.contact = contact;
        this.birth = birth;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;
    }
}
