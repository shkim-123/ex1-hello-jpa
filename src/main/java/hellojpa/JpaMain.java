package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작

        try {
            //　저장
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

            // 조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());
//            findMember.setName("HelloJPA");

            // JPQL
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(8)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }

            /*
            // 비영속
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            // 영속
            System.out.println("=== BEFORE ===");
            em.persist(member);
            System.out.println("=== AFTER ===");

            // 1차 캐시에서 조회
            Member findMember = em.find(Member.class, 101L);
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());
             */

            /*
            // 영속
            Member findMember1 = em.find(Member.class, 101L); // DB 조회 후 1차 캐시에 저장
            Member findMember2 = em.find(Member.class, 101L); // 1차 캐시에서 조회

            System.out.println("result = " + (findMember1 == findMember2));
             */

            /*
            // 쓰기 지연 SQL 저장소
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);
            // 여기까지 insert sql을 데이터베이스에 보내지 않는다
             */

            /*
            // 변경 감지
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZ");
             */

            /*
            // 플러시 : 영속성 컨텍스트의 변경내용을 데이터베이스에 반영
            Member member = new Member(200L, "member200");
            em.persist(member);

            em.flush(); // 직접 호출
             */

            /*
            // 준영속 상태
            Member member = em.find(Member.class, 150L);
            member.setName("AAAA");

            // 영속성 컨텍스트에서 분리
//            em.detach(member);

            // 영속성 컨텍스트 다 지우기
            em.clear();
            // 영속성 컨텍스트가 clear되어 다시 db에서 조회
            Member member2 = em.find(Member.class, 150L);
             */

            Member member = new Member();
//            member.setId(1L);
//            member.setUsername("A");
//            member.setRoleTpye(RoleType.USER);

//            member.setId(2L);
//            member.setUsername("B");
//            member.setRoleTpye(RoleType.ADMIN);

            member.setId(3L);
            member.setUsername("C");
            member.setRoleType(RoleType.GUEST);


            em.persist(member);

            System.out.println("===========================");

            // 커밋하는 순간 insert sql을 보낸다
            tx.commit(); // 트랜잭션 커밋
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
