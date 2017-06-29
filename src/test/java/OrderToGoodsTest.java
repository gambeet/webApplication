import model.GoodsEntity;
import model.OrderToGoodsEntity;
import model.OrdersEntity;
import org.junit.Assert;
import org.junit.Test;
import utils.HibernateController;

/**
 * Created by ness5 on 29.06.2017.
 */
public class OrderToGoodsTest {
    @Test
    public void testWorkWithOrderToGoodsTable(){
        OrderToGoodsEntity oge = new OrderToGoodsEntity();
        Assert.assertNotEquals("Goods table is empty", HibernateController.read("Goods").size(), 0);
        GoodsEntity goods = (GoodsEntity) HibernateController.read("Goods").get(0);
        oge.setGoodsByGoodsId(goods);
        Assert.assertNotEquals("Orders table is empty", HibernateController.read("Orders").size(), 0);
        OrdersEntity order = (OrdersEntity) HibernateController.read("Orders").get(0);
        oge.setOrdersByOrderId(order);
        oge.setQuantity(15);
        HibernateController.create(oge);

        OrderToGoodsEntity ogeI = (OrderToGoodsEntity) HibernateController.findElementById(oge.getId(), "OrderToGoods");
        Assert.assertNotNull("Failed add to OrderToGoods table", ogeI);

        oge = new OrderToGoodsEntity();
        oge.setId(ogeI.getId());
        oge.setGoodsByGoodsId(goods);
        oge.setOrdersByOrderId(order);
        oge.setQuantity(25);
        HibernateController.update(oge, "OrderToGoods");

        OrderToGoodsEntity ogeU = (OrderToGoodsEntity) HibernateController.findElementById(oge.getId(), "OrderToGoods");
        Assert.assertEquals("Failed update element from OrderToGoods table", ogeU, ogeI);

        HibernateController.delete("OrderToGoods", oge.getId());

        OrderToGoodsEntity ogeD = (OrderToGoodsEntity) HibernateController.findElementById(oge.getId(), "OrderToGoods");

        Assert.assertNull("Failed detele from OrderToGoods table", ogeD);

    }
}
