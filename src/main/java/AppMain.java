import Parameter.ParameterEntity;
import User.UserEntity;

import org.apache.lucene.LucenePackage;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.engine.impl.LuceneQueryDescriptor;
import org.hibernate.search.jpa.FullTextEntityManager;
import javax.persistence.*;
import javax.persistence.EntityManager;
import java.util.List;
import Parameter.ParameterEntityDAO;
import static User.UserDao.addUser;
import org.hibernate.search.jpa.*;
import org.hibernate.search.query.dsl.QueryBuilder;

public class AppMain {

    private static EntityManagerFactory ef = Persistence.createEntityManagerFactory( "hibernateCRUD3" );
    public static void main(String[] args) {

        ParameterEntityDAO paramdao = new ParameterEntityDAO();

        List<ParameterEntity> allparams = paramdao.getAllParameters();

        paramdao.addParameter("saat onda eklendi","saat on kırkiki",25.65,27.8);

        List<ParameterEntity> allparams2 = paramdao.getAllParameters();


        List<ParameterEntity> params = paramdao.searchParamViaName("o");

        ParameterEntity p = paramdao.getParameterById(5);

        paramdao.updateParameter(5,"yeniad",null,null,null);
        System.out.println(params);




//        int i;
//        EntityManager em = ef.createEntityManager();
//        EntityTransaction et = em.getTransaction();
//        String strQuery = "SELECT c FROM ParameterEntity c WHERE c.id IS NOT NULL";
//        String strQueryFilter="SELECT c from ParameterEntity c where c.paramName like '%o%'";
//        String SearchSt = "o";
//        Query query = em.createQuery("SELECT c from ParameterEntity c where c.paramName like '%'||:SearchSt||'%'");
//        query.setParameter("SearchSt",SearchSt);
//        TypedQuery<ParameterEntity> tq = em.createQuery(strQuery,ParameterEntity.class);
//        List<ParameterEntity> params;
//        List<ParameterEntity> plist;
//
//        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);
//
//        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
//                .buildQueryBuilder()
//                .forEntity(ParameterEntity.class)
//                .get();
//        org.apache.lucene.search.Query luceneQuery = queryBuilder
//                .keyword()
//                .onField("paramName")
//                .matching("Esso")
//                .createQuery();
//        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery,ParameterEntity.class);
//
//
//
//        try {
//            plist = query.getResultList();
//            params = tq.getResultList();
////            for(i = 0; i<params.size();i++) {
////                ParameterEntity p = params.get(i);
////                p.setParamDetails(p.getParamDetails() + " -- " + p.getParamName() + " -- " + i);
////                et.begin();
////                em.merge(p);
////                et.commit();
////            }
////            et.begin();
////
////            ParameterEntity p = new ParameterEntity();
////            p.setParamName("I can see you");
////            p.setParamDetails("important to see");
////            p.setParamMax(95.0);
////            p.setParamMin(54.0);
////
////            em.persist(p);
////            et.commit();
//            System.out.println(params);
//        }
//        catch (Exception e){
//            if(et != null){
//                et.rollback();
//            }
//            e.printStackTrace();
//        }
//        finally {
//            em.close();
//        }
//        //addUser(1,"Bora Saktanber","bora@gmail.com","123456789");

    }




//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        Session session = factory.openSession();
//        Transaction transaction =  session.getTransaction();


//        EntityManager entityManager = ef.createEntityManager();
//        entityManager.getTransaction().begin();
//
//
//        UserEntity user = new UserEntity();
//
////        user.setId(1);
//        user.setEmail("Deniz.Saktanber@scheidt-bachmann.dee");
//        user.setName("Nag Saktanber");
//        user.setPassword("+B10522409250s-");
////
//        entityManager.persist(user);
//        entityManager.getTransaction().commit();
//        entityManager.close();
////        ParameterEntity param = new ParameterEntity();
////
////        param.setParamDetails("important");
////        param.setParamName("Shell");
//
//
////        try{
//////            transaction.begin();
//////            session.save(user);
//////            //session.save(param);
//////            //session.delete(user);
//////            transaction.commit();
////
////        }
////        catch(Exception e){
////            transaction.rollback();
////            System.out.println(e.toString());
////        }
////        finally {
////            session.close();
////        }
////
    }
