package com.project.spring_study_roadmap.jpql;

import jakarta.persistence.*;

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

            Team team = new Team();
            team.setName("teamA");

            em.persist(team);

            Member member = new Member();
            member.setUsername("관리자");
            member.setAge(10);
            member.setTeam(team);

            em.persist(member);


            em.flush();
            em.clear();
            /*String query = "select m from Member m left join Team t on m.username = t.name";

            List<Member> resultList = em.createQuery(query, Member.class)
                    .getResultList();*/
            /*String query = "select " +
                                    "case when m.age <= 10 then '학생요금'" +
                                        " when m.age >= 60 then '경로요금'" +
                                        " else '일반요금'" +
                                        "end " +
                    "from Member m";*/

            String query = "select nullif(m.username, '관리자') as username from Member m";
            List<String> resultList = em.createQuery(query, String.class).getResultList();

            for (String s : resultList) {
                System.out.println("s = " + s);
            }

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
    }
}
