import model.ClientsEntity;
import org.junit.Assert;
import org.junit.Test;
import utils.HibernateController;

/**
 * Created by ness5 on 27.06.2017.
 */
public class ClientsTest {
    @Test
    public void testWorkWithClientsTable(){
        ClientsEntity ce = new ClientsEntity();
        ce.setFio("ExampleName");
        ce.setAddress("ExampleAddress");
        ce.setPhone("+388005553535");
        HibernateController.create(ce);

        ClientsEntity ceI = (ClientsEntity) HibernateController.findElementById(ce.getId(), "Clients");
        Assert.assertNotNull("Failed add to Clients table", ceI);

        ce = new ClientsEntity();
        ce.setId(ceI.getId());
        ce.setAddress("ExampleAddress");
        ce.setPhone("+388005553535");
        ce.setFio("nameName");
        HibernateController.update(ce, "Clients");

        ClientsEntity ceU = (ClientsEntity) HibernateController.findElementById(ce.getId(), "Clients");
        Assert.assertEquals("Failed update element from Clients table",ceI, ceU);

        HibernateController.delete("Clients", ce.getId());

        ClientsEntity ceD = (ClientsEntity) HibernateController.findElementById(ce.getId(), "Clients");
        Assert.assertNull("Failed detele from Clients table", ceD);

    }
}
