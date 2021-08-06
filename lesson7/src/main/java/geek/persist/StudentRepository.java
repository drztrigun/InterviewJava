package geek.persist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class StudentRepository {

    private final EntityManagerFactory emFactory;

    public StudentRepository(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public List<Student> findAll(){
        EntityManager em = emFactory.createEntityManager();
        try{
            return em.createNamedQuery("allStudent", Student.class).getResultList();
        }finally {
            if (em != null){
                em.close();
            }
        }
    }

    public Student findById(long id){
        EntityManager em = emFactory.createEntityManager();
        try{
            return em.find(Student.class, id);
        }finally {
            if (em != null){
                em.close();
            }
        }
    }

    public void insert(Student student){
        EntityManager em = emFactory.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }catch (Exception exception){
            em.getTransaction().rollback();
        }finally {
            if (em != null){
                em.close();
            }
        }
    }

    public void update(Student student){
        EntityManager em = emFactory.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        }catch (Exception exception) {
            em.getTransaction().rollback();
        }finally {
            if (em != null){
                em.close();
            }
        }
    }

    public void delete(long id){
        EntityManager em = emFactory.createEntityManager();
        try{
            Student student = em.find(Student.class, id);
            if (student != null) {
                em.getTransaction().begin();
                em.remove(id);
                em.getTransaction().commit();
            }
        } catch (Exception exception) {
            em.getTransaction().rollback();
        } finally {
            if (em != null){
                em.close();
            }
        }
    }



}
