package com.project.spring_study_roadmap.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            User user = User.builder()
                    .contact("010-1234-5678")
                    .birth("19970320")
                    .homeAddress(new Address("서울", "강남대로", "06236"))
                    .workAddress(new Address("판교", "테크노밸리로", "13524"))
                    .build();

            // 이전 주소 기록
            user.getPastAddress().add(new Address("대전", "중구 중앙로", "35000"));
            user.getPastAddress().add(new Address("부산", "해운대로", "60100"));

            // 주문 1건 생성
            Order order1 = Order.builder()
                    .orderStatus(OrderEnum.ATMOS)
                    .build();

            // 주문 상품들 생성
            OrderItem item1 = OrderItem.builder()
                    .productName("맥북 프로")
                    .price(3000000)
                    .build();

            OrderItem item2 = OrderItem.builder()
                    .productName("에어팟 프로")
                    .price(350000)
                    .build();

            // 연관관계 연결
            order1.addOrderItem(item1);
            order1.addOrderItem(item2);
            user.addOrder(order1);

            // 저장
            em.persist(user);


            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
