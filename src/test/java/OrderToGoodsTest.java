import model.EntityInterface;
import model.GoodsEntity;
import model.OrderToGoodsEntity;
import model.OrdersEntity;
import org.junit.Test;
import utils.HibernateController;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by ness5 on 29.06.2017.
 */
public class OrderToGoodsTest {
    @Test
    public void myTest(){
        boolean testCreateRead = false;
        boolean testDelete = false;
        boolean testUpdate = false;
        OrderToGoodsEntity oge = new OrderToGoodsEntity();

        HibernateController controller = new HibernateController();

        oge.setGoodsByGoodsId((GoodsEntity) controller.findElementById(0, "Goods"));
        oge.setOrdersByOrderId((OrdersEntity) controller.findElementById(4, "Orders"));
        oge.setQuantity(15);

        controller.create(oge);

        List<EntityInterface> rows = controller.read("OrderToGoods");
        if(rows.contains(oge)){
            testCreateRead = true;
        }

        oge.setQuantity(25);
        controller.update(oge, "OrderToGoods");
        rows = controller.read("OrderToGoods");

        if(rows.contains(oge)){
            testUpdate = true;
        }

        controller.delete("OrderToGoods", rows.get(rows.indexOf(oge)).getId());

        rows = controller.read("OrderToGoods");

        if(!rows.contains(oge)) {
            testDelete = true;
        }

        assertTrue(testCreateRead);
        assertTrue(testDelete);
        assertTrue(testUpdate);
    }
}
