package com.project.spring_study_roadmap.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itermPrice);
}
