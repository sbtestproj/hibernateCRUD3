import Parameter.ParameterEntity;
import javax.persistence.*;
import java.util.List;
import Parameter.ParameterEntityDAO;

public class AppMain {

    //private static EntityManagerFactory ef = Persistence.createEntityManagerFactory("hibernateCRUD3");

    public static void main(String[] args) {

        ParameterEntityDAO paramdao = new ParameterEntityDAO();

        List<ParameterEntity> allparams = paramdao.getAllParameters();

        paramdao.addParameter("saat onda eklendi","saat on kırkiki",25.65,27.8);

        List<ParameterEntity> allparams2 = paramdao.getAllParameters();

        List<ParameterEntity> params = paramdao.searchParamViaName("o");

        ParameterEntity p = paramdao.getParameterById(5);

        paramdao.updateParameter(5,"yeniad",null,null,null);

        paramdao.deleteParameterById(11);

        paramdao.deleteParameterByName("saat onda eklendi");

        List<ParameterEntity> allparams3 = paramdao.getAllParameters();

        System.out.println(params);
        System.out.println(allparams3);
    }
}
