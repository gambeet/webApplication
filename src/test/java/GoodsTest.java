import model.GoodsEntity;
import org.junit.Assert;
import org.junit.Test;
import utils.HibernateController;

/**
 * Created by ness5 on 29.06.2017.
 */
public class GoodsTest {
    @Test
    public void testWorkWithGoodsTable(){
        GoodsEntity ge = new GoodsEntity();
        ge.setManufacturer("Sony");
        ge.setModel("AMX-30");
        ge.setPrice(11.55);
        ge.setDescription("simpleDescription");
        HibernateController.create(ge);

        GoodsEntity geI = (GoodsEntity)HibernateController.findElementById(ge.getId(), "Goods");
        Assert.assertNotNull("Failed add to Goods table", geI);

        ge = new GoodsEntity();
        ge.setId(geI.getId());
        ge.setManufacturer("Sony");
        ge.setPrice(11.55);
        ge.setDescription("simpleDescription");
        ge.setModel("XRN2");
        HibernateController.update(ge, "Goods");

        GoodsEntity geU = (GoodsEntity)HibernateController.findElementById(ge.getId(), "Goods");
        Assert.assertEquals("Failed update element from Goods table", geI, geU);

        HibernateController.delete("Goods", ge.getId());

        GoodsEntity geD = (GoodsEntity) HibernateController.findElementById(ge.getId(), "Goods");
        Assert.assertNull("Failed detele from Clients table", geD);

    }
}
