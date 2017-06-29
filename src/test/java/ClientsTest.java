import model.ClientsEntity;
import model.EntityInterface;
import org.junit.Test;
import utils.HibernateController;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by ness5 on 27.06.2017.
 */
public class ClientsTest {
    @Test
    public void myTest(){
        boolean testCreateRead = false;
        boolean testDelete = false;
        boolean testUpdate = false;
        ClientsEntity ce = new ClientsEntity();

        ce.setFio("ExampleName");
        ce.setAddress("ExampleAddress");
        ce.setPhone("+388005553535");

        HibernateController controller = new HibernateController();

        controller.create(ce);

        List<EntityInterface> rows = controller.read("Clients");
        if(rows.contains(ce)){
            testCreateRead = true;
        }

        ce.setFio("nameName");
        controller.update(ce, "Clients");
        rows = controller.read("Clients");

        if(rows.contains(ce)){
           testUpdate = true;
        }

        controller.delete("Clients", rows.get(rows.indexOf(ce)).getId());

        rows = controller.read("Clients");

        if(!rows.contains(ce)) {
            testDelete = true;
        }

        assertTrue(testCreateRead);
        assertTrue(testDelete);
        assertTrue(testUpdate);
    }
}
