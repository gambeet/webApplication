import model.ClientsEntity;
import model.EntityInterface;
import model.OrdersEntity;
import org.junit.Test;
import utils.HibernateController;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by ness5 on 29.06.2017.
 */
public class OrdersTest {
    @Test
    public void myTest(){
        boolean testCreateRead = false;
        boolean testDelete = false;
        boolean testUpdate = false;
        OrdersEntity oe = new OrdersEntity();
        Date date = new Date(System.currentTimeMillis());
        HibernateController controller = new HibernateController();

        oe.setDate(date);
        oe.setPaid(true);
        oe.setClientsByClientId((ClientsEntity) controller.findElementById(0, "Clients"));


        controller.create(oe);

        List<EntityInterface> rows = controller.read("Orders");
        if(rows.contains(oe)){
            testCreateRead = true;
        }

        oe.setPaid(false);
        controller.update(oe, "Orders");
        rows = controller.read("Orders");

        if(rows.contains(oe)){
            testUpdate = true;
        }

        controller.delete("Orders", rows.get(rows.indexOf(oe)).getId());

        rows = controller.read("Goods");

        if(!rows.contains(oe)) {
            testDelete = true;
        }

        assertTrue(testCreateRead);
        assertTrue(testDelete);
        assertTrue(testUpdate);
    }
}
