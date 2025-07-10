package com.project.spring_study_roadmap.hellojpa;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

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


            /*Member2 member2 = new Member2();
            member2.setUsername("USER");

            System.out.println("===VVV");
            em.persist(member2);

            System.out.println("id: " + member2.getId());*/


            // 1차 캐시 때문에 양방향이면 값을 넣어줘야 한다.
            // 1 : N
            /*Team team = new Team();
            team.setName("TEAM");
            em.persist(team);

            // N : 1
            Member member = new Member();
            member.setUsername("userA");
            member.setTeam(team);

            em.persist(member);

            Member m = em.find(Member.class, member.getId());*/

            /*Movie movie = new Movie();

            movie.setDirector("A");
            movie.setActor("B");
            movie.setName("바람과 함께 사라진다.");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie findMove = em.find(Movie.class, movie.getId());
            System.out.println("findMove = " + findMove);*/

            /*Member member = new Member();
            member.setCreatedBy("User1");
            member.setUsername("hi");

            em.persist(member);*/

/*
            List<Member> members = member.getTeam().getMembers();

            for (Member m : members) {
                System.out.println("m.getUsername() = " + m.getUsername());
            }
*/

            /*Member member = em.find(Member.class, 1L);
            //printMemberAndTeam(member);

            printMember(member);*/


            //Member findMember = em.find(Member.class, member.getId());
            //System.out.println("findMember.getId() = " + findMember.getId());
            //System.out.println("findMember.getUsername() = " + findMember.getUsername());

            /*Member findMember = em.getReference(Member.class, member.getId());
            System.out.println("findMember = " + findMember.getClass());
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getUsername() = " + findMember.getUsername());
            System.out.println("findMember.getUsername() = " + findMember.getUsername());*/

            /*Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setTeam(team);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setTeam(team);
            em.persist(member2);

            em.flush();
            em.clear();*/

            //Member m = em.find(Member.class, member1.getId());
            /*System.out.println("m.getTeam().getClass() = " + m.getTeam().getClass());

            System.out.println("======");
            System.out.println("m.getTeam().getName() = " + m.getTeam().getName()); // 객체의 값을 가져올 때 쿼리를 조회
            System.out.println("======");*/

            //List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();



            /*Child child1 = new Child();
            Child child2 = new Child();


            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            em.remove(findParent);*/

//            findParent.getChildList().remove(0);
            /*Address address = new Address("city", "street", "10");

            Member member = new Member();
            member.setUsername("hello1");
           // member.setHomeAddress(address);
            em.persist(member);*/

            /*Address copyAddress = new Address("city", "street", "10");

            Member member2 = new Member();
            member2.setUsername("hello2");
            member2.setHomeAddress(copyAddress);
            em.persist(member2);*/


 //           member.getHomeAddress().setCity("newCity");

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("homeCity1", "street", "10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity("old1", "street", "1000"));
            member.getAddressHistory().add(new AddressEntity("old2", "street", "1000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("==== start ====");
            Member findMember = em.find(Member.class, member.getId());

            //findMember.getAddressHistory().
            Address homeAddress = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("파주", homeAddress.getStreet(), homeAddress.getZipcode()));

            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

            findMember.getAddressHistory().remove(new AddressEntity("old1", "street", "1000"));
            findMember.getAddressHistory().add(new AddressEntity("newOld1", "street", "1000"));

            System.out.println("==== end ====");

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }

    /*private static void printMember(Member member) {
        System.out.println("member.getUsername() = " + member.getUsername());
    }

    private static void printMemberAndTeam(Member member) {

        String username = member.getUsername();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        String name = team.getName();
        System.out.println("name = " + name);
    }*/
}
