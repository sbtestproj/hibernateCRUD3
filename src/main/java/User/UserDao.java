package User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.*;

public class UserDao
{
    private static EntityManagerFactory ef = Persistence.createEntityManagerFactory( "hibernateCRUD3" );

    public static void getUser(int id) {
        EntityManager em = ef.createEntityManager();
        String query = "SELECT c FROM UserEntity c WHERE c.id =:userID";
        TypedQuery<UserEntity> tq = em.createQuery(query, UserEntity.class);
        tq.setParameter("userID", id);
        UserEntity user = null;

        try {
            user = tq.getSingleResult();
            System.out.println(user.getName()+" "+user.getEmail());
        } catch (NoResultException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    public static void addUser(int id, String name, String email, String password) {

            EntityManager em = ef.createEntityManager();
            EntityTransaction et = null;
            try {
                et = em.getTransaction();
                et.begin();
                UserEntity user = new UserEntity();
                user.setId(id);
                user.setPassword(password);
                user.setName(name);
                user.setEmail(email);
                em.persist(user);
                et.commit();
            } catch (Exception e) {
                if (et != null) {
                    et.rollback();
                }
                e.printStackTrace();
            } finally {
                em.close();
            }
        }
//        int i = 0;
//
//        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
//        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
//
//        SessionFactory factory = meta.getSessionFactoryBuilder().build();
//        Session session = factory.openSession();
//        Transaction t = session.beginTransaction();
//
//
//        i = (Integer)session.save(u);
//
//        t.commit();
//        session.close();
//
//        return i;

    }
