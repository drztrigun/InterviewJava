package geek;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

class AbstractRepository<T, ID extends Serializable> {

    private Session currentSession;
    private Transaction currentTransaction;

    private Class<T> entityClass;

    public AbstractRepository(Class entityClass) {
        this.entityClass = entityClass;
    }

    public Session openCurrentSession(){
        currentSession = getSessionFactory(entityClass).openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction(){
        currentSession = getSessionFactory(entityClass).openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession(){
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction(){
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory(Class addClass){
        Configuration configuration = new Configuration().configure().addAnnotatedClass(addClass);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession(){
        return currentSession;
    }

    public void setCurrentSession(Session currentSession){
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction(){
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction){
        this.currentTransaction = currentTransaction;
    }

    public void create(T entity){
        getCurrentSession().save(entity);
    }

    public void update(T entity){
        getCurrentSession().update(entity);
    }

    public T findById(ID id){
        T entity = (T) getCurrentSession().get(entityClass, id);
        return entity;
    }

    public void delete(T entity){
        getCurrentSession().delete(entity);
    }



}
