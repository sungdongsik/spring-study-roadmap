package com.project.spring_study_roadmap.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderEnum orderStatus;

    private LocalDateTime createDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public OrderEnum getOrderStatus() {
        return orderStatus;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public User getUser() {
        return user;
    }

    public void addUser(User user) {
        this.user = user;
    }

    public void addOrderItem(OrderItem orderItem){
        this.orderItems.add(orderItem);
        orderItem.addOrder(this);
    }

    @Builder
    public Order(Long id, OrderEnum orderStatus) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.createDateTime = LocalDateTime.now();
    }
}
