package com.project.spring_study_roadmap.jpashop;

import com.project.spring_study_roadmap.jpashop.domain.Book;
import com.project.spring_study_roadmap.jpashop.domain.Order;
import com.project.spring_study_roadmap.jpashop.domain.OrderItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            /*Team team = new Team();
            team.setName("TeamA");
            //team.getMembers().add(member);
            em.persist(team);

            Member member = new Member();
            member.setName("member1");
            //member.changeTeam(team);
            em.persist(member);

            team.addMember(member);

            *//*em.flush();
            em.clear();*//*

            Team findTeam = em.find(Team.class, team.getId()); // 1차 캐시에 있는 상태
            List<Member> members = findTeam.getMembers();

            // 컨트롤러에서 entity 반환하지말자 안 그러면 무한루프에 빠질 수 있다.
            // entity 수정 시 api 스펙이 변경될 수 있으니 dto를 사용하자
            System.out.println("============");
            System.out.println("members.toString() = " + members.toString());

            System.out.println("============");*/

            /*Order order = new Order();
            order.addOrderItem(new OrderItem());

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);*/

            Book book = new Book();

            book.setName("jpa");
            book.setAuthor("김영하");

            em.persist(book);


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
