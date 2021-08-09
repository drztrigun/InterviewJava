package geek;

import geek.persist.Student;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = emFactory.createEntityManager();

        //INSERT
        em.getTransaction().begin();
        Student student1 = new Student("student1", 22);
        Student student2 = new Student("student2", 23);
        Student student3 = new Student("student3", 21);
        Student student4 = new Student("student4", 20);
        Student student5 = new Student("student5", 22);
        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        em.persist(student4);
        em.persist(student5);

        em.getTransaction().commit();

        em.close();
    }
}
