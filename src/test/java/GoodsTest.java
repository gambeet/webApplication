import model.EntityInterface;
import model.GoodsEntity;
import org.junit.Test;
import utils.HibernateController;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ness5 on 29.06.2017.
 */
public class GoodsTest {
    @Test
    public void myTest(){
        boolean testCreateRead = false;
        boolean testDelete = false;
        boolean testUpdate = false;
        GoodsEntity ge = new GoodsEntity();

        ge.setManufacturer("Sony");
        ge.setModel("AMX-30");
        ge.setPrice(11.55);
        ge.setDescription("simpleDescription");

        HibernateController controller = new HibernateController();

        controller.create(ge);

        List<EntityInterface> rows = controller.read("Goods");
        if(rows.contains(ge)){
            testCreateRead = true;
        }

        ge.setModel("XRN2");
        controller.update(ge, "Goods");
        rows = controller.read("Goods");

        if(rows.contains(ge)){
            testUpdate = true;
        }

        controller.delete("Goods", rows.get(rows.indexOf(ge)).getId());

        rows = controller.read("Goods");

        if(!rows.contains(ge)) {
            testDelete = true;
        }

        assertTrue(testCreateRead);
        assertTrue(testDelete);
        assertTrue(testUpdate);
    }
}
