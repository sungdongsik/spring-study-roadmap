package com.project.spring_study_roadmap.jpql;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {



            /*List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
                    .getResultList();*/
            //TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
            //Query query = em.createQuery("select m.username, m.age from Member m");


            //Member resultList = query1.getSingleResult();

            /*for (Member m : resultList) {
                System.out.println("m.getUsername() = " + m.getUsername());
            }*/

            //Member findMember = resultList.get(0);
            //findMember.setAge(20);


            /*Object[] objects = resultList.get(0);

            System.out.println("objects[0] = " + objects[0]);
            System.out.println("objects[1] = " + objects[1]);*/

            //MemberDTO memberDTO = resultList.get(0);

            Team team1 = new Team();
            team1.setName("teamA");

            Team team2 = new Team();
            team2.setName("teamB");

            em.persist(team1);
            em.persist(team2);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setAge(10);
            member1.setTeam(team1);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setAge(20);
            member2.setTeam(team2);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("member3");
            member3.setAge(20);
            member3.setTeam(team2);
            em.persist(member3);


            /*String query = "select m from Member m left join Team t on m.username = t.name";

            List<Member> resultList = em.createQuery(query, Member.class)
                    .getResultList();*/
            /*String query = "select " +
                                    "case when m.age <= 10 then '학생요금'" +
                                        " when m.age >= 60 then '경로요금'" +
                                        " else '일반요금'" +
                                        "end " +
                    "from Member m";*/

            /*String query = "select m from Member m where m.team = :team";
            List<Member> resultList = em.createQuery(query, Member.class)
                    .setParameter("team", team1)
                    .getResultList();

            System.out.println("resultList = " + resultList.size());

            for (Member team : resultList) {
                System.out.println("team = " + team);

                *//*for (Member m : team.getMembers()){
                    System.out.println("m = " + m);
                }*//*
            }*/

            /*List<Member> members = em.createNamedQuery("Member.findByUsername", Member.class)
                    .setParameter("username", "회원1")
                    .getResultList();

            for (Member member : members) {
                System.out.println("member = " + member);
            }*/

            int resultCount = em.createQuery("update Member m set m.age = 20").executeUpdate();

            //em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member1.getId());

            System.out.println("findMember.getAge() = " + findMember.getAge());

            System.out.println("resultCount = " + resultCount);

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
    }
}
