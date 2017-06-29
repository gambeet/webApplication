import model.ClientsEntity;
import model.OrdersEntity;
import org.junit.Assert;
import org.junit.Test;
import utils.HibernateController;

import java.sql.Date;

/**
 * Created by ness5 on 29.06.2017.
 */
public class OrdersTest {
    @Test
    public void testWorkWithOrdersTable(){
        OrdersEntity oe = new OrdersEntity();
        Date date = new Date(System.currentTimeMillis());
        oe.setDate(date);
        oe.setPaid(true);
        ClientsEntity client = (ClientsEntity) HibernateController.read("Clients").get(0);
        Assert.assertNotNull("Clients table is empty", client);
        oe.setClientsByClientId(client);
        HibernateController.create(oe);

        OrdersEntity oeI = (OrdersEntity) HibernateController.findElementById(oe.getId(), "Orders");
        Assert.assertNotNull("Failed add to Orders table", oeI);

        oe = new OrdersEntity();
        oe.setId(oeI.getId());
        oe.setDate(date);
        oe.setPaid(false);
        oe.setClientsByClientId(client);
        HibernateController.update(oe, "Orders");

        OrdersEntity oeU = (OrdersEntity) HibernateController.findElementById(oe.getId(), "Orders");
        Assert.assertEquals("Failed update element from Orders table", oe, oeU);

        HibernateController.delete("Orders", oe.getId());

        OrdersEntity oeD = (OrdersEntity) HibernateController.findElementById(oe.getId(), "Orders");
        Assert.assertNull("Failed detele from Orders table", oeD);
    }
}
