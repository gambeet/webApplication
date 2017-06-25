package utils;

import model.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateController {

    private static Session hibernateSession;

    static {
        hibernateSession = HibernateSessionFactory.getSessionFactory().openSession();
    }

    public static void create(EntityInterface element){
        hibernateSession.getTransaction().begin();
        hibernateSession.save(element);
        hibernateSession.getTransaction().commit();
    }

    public static List<EntityInterface> read(String tableName){
        List<EntityInterface> rows = null;
        Query query = null;
        query = hibernateSession.createNamedQuery(tableName + ".findAll");
        rows = query.list();
        return rows;
    }

    public static void update(EntityInterface element, String tableName){
        hibernateSession.getTransaction().begin();
        if(element == null)
            return;
        EntityInterface editableElement = findElementById(element.getId(), tableName);
        if(element instanceof ClientsEntity){
            ((ClientsEntity)editableElement).setFio(((ClientsEntity)element).getFio());
            ((ClientsEntity)editableElement).setAddress(((ClientsEntity)element).getAddress());
            ((ClientsEntity)editableElement).setPhone(((ClientsEntity)element).getPhone());
        }else if(element instanceof GoodsEntity){
            ((GoodsEntity)editableElement).setManufacturer(((GoodsEntity)element).getManufacturer());
            ((GoodsEntity)editableElement).setModel(((GoodsEntity)element).getModel());
            ((GoodsEntity)editableElement).setPrice(((GoodsEntity)element).getPrice());
            ((GoodsEntity)editableElement).setDescription(((GoodsEntity)element).getDescription());
        }else if(element instanceof OrdersEntity){
            System.out.println(((OrdersEntity)element).toHtmlTableRow());
            ((OrdersEntity)editableElement).setDate(((OrdersEntity)element).getDate());
            ((OrdersEntity)editableElement).setPaid(((OrdersEntity)element).isPaid());
            ((OrdersEntity)editableElement).setClientsByClientId(((OrdersEntity)element).getClientsByClientId());
        }else if(element instanceof OrderToGoodsEntity){
            ((OrderToGoodsEntity)editableElement).setQuantity(((OrderToGoodsEntity)element).getQuantity());
            ((OrderToGoodsEntity)editableElement).setOrdersByOrderId(((OrderToGoodsEntity)element).getOrdersByOrderId());
            ((OrderToGoodsEntity)editableElement).setGoodsByGoodsId(((OrderToGoodsEntity)element).getGoodsByGoodsId());
        }
        hibernateSession.getTransaction().commit();
    }

    public static void delete(String tableName, long id){
        hibernateSession.getTransaction().begin();
        Query query =  hibernateSession.createNamedQuery(tableName+".deleteElement");
        query.setParameter("id", id);
        query.executeUpdate();
        hibernateSession.getTransaction().commit();
    }

    public static EntityInterface findElementById(long id, String tableName){
        List<EntityInterface> list = (List<EntityInterface>) hibernateSession.createNamedQuery(tableName + ".findAll").list();
        for (EntityInterface row : list) {
            if (row.getId() == id) {
                return row;
            }
        }
        return null;
    }

}
