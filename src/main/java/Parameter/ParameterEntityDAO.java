package Parameter;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import java.util.List;


public class ParameterEntityDAO {

    private static EntityManagerFactory ef = Persistence.createEntityManagerFactory( "hibernateCRUD3" );
    private static EntityManager em = ef.createEntityManager();
    private static EntityTransaction et = em.getTransaction();

    public List<ParameterEntity> getAllParameters(){

        String strQuery = "SELECT c FROM ParameterEntity c WHERE c.id IS NOT NULL";
        TypedQuery<ParameterEntity> tq = em.createQuery(strQuery,ParameterEntity.class);
        List<ParameterEntity> params;
        params = tq.getResultList();
        if(params == null)
        {
            System.out.println("There is no Parameter");
        }
        return params;
    }

    public ParameterEntity getParameterById(int id){
        ParameterEntity param;
        param = em.find(ParameterEntity.class,id);
        return param;
    }

    public List<ParameterEntity> searchParamViaName(String searchStr){

        Query query = em.createQuery("SELECT c from ParameterEntity c where c.paramName like '%'||:SearchSt||'%'");
        query.setParameter("SearchSt",searchStr);
        List<ParameterEntity> params;
        params = query.getResultList();

        return params;
    }

    public void updateParameter(int paramID, @Nullable String newName, @Nullable String newDefinition,@Nullable Double newMax,@Nullable Double newMin){
        ParameterEntity param = getParameterById(paramID);
        if(newName != null)
            param.setParamName(newName);
        if(newName != null)
            param.setParamDetails(newDefinition);
        if(newName != null)
            param.setParamMin(newMin);
        if(newName != null)
            param.setParamMax(newMax);
        et.begin();
        em.merge(param);
        et.commit();
        et.rollback();
    }
}
