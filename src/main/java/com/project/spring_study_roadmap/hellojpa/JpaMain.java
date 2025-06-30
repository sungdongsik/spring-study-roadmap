package com.project.spring_study_roadmap.hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /*Member member = new Member();
            member.setId(100L);
            member.setName("Hello");*/
            //Member member = em.find(Member.class, 30L);
            //System.out.println("member.getId() = " + member.getId());
            //em.remove(member);
            //em.persist(member);
            //member.setName("helloJpa");

//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(10)
//                    .getResultList();

            /*for (Member member : result) {
                System.out.println("member = " + member.getId());
            }*/

            // 비영속
            /*Member member = new Member();
            member.setId(101L);
            member.setName("HelloJpa");

            // 영속성
            System.out.println("==BEFORE==");
            em.persist(member);
            System.out.println("==AFTER==");*/

            /*Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);

            System.out.println("id: " + findMember1.getId());
            System.out.println("name: " + findMember1.getName());

            System.out.println("id: " + findMember2.getId());
            System.out.println("name: " + findMember2.getName());*/



            /*Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");
            */
            /*em.persist(member1);
            em.persist(member2);*/

            /*Member member1 = em.find(Member.class, 150L);
            member1.setName("ZZZZZ");*/

            /*Member member = new Member(200L, "member200");
            em.persist(member);

            em.flush();*/

            /*Member member = em.find(Member.class, 150L);
            //member.setName("AAAAA");

            //em.detach(member);
            // 영속성 컨테스트 통으로 지워버림
            em.clear();

            Member member2 = em.find(Member.class, 150L);
            //member.setName("AAAAA");*/


            /*Member member = new Member();
            member.setUsername("C");
            member.setRoleType(RoleType.ADMIN);

            em.persist(member);*/


            Member2 member2 = new Member2();
            member2.setUsername("USER");

            System.out.println("===VVV");
            em.persist(member2);

            System.out.println("id: " + member2.getId());
            System.out.println("========");



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
