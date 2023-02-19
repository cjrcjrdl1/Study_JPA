package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Address address = new Address("city", "street", "zipcode");

            Member member = new Member();
            member.setUsername("hello");
            member.setHomeAddress(address);

            Member member2 = new Member();
            member2.setUsername("hello");
            member2.setHomeAddress(address);

            em.persist(member);
            em.persist(member2);

//            member.getHomeAddress().setCity("newCity");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally{
            em.close();
        }

        emf.close();
    }


}
