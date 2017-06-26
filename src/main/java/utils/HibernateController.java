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
        hibernateSession.merge(element);
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
