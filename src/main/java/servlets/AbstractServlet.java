package servlets;

import model.*;
import utils.HibernateController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AbstractServlet extends HttpServlet {
    public static EntityInterface getElementFromRequest(HttpServletRequest request, String currentTable){
        EntityInterface element = null;
        switch (currentTable) {
            case "Clients":
                element = new ClientsEntity();
                if(request.getParameter("id") != null){
                    ((ClientsEntity) element).setId(Integer.parseInt(request.getParameter("id")));
                }
                ((ClientsEntity) element).setAddress(request.getParameter("address"));
                ((ClientsEntity) element).setFio(request.getParameter("fio"));
                if (request.getParameter("phone") != null) {
                    ((ClientsEntity) element).setPhone(request.getParameter("phone"));
                }
                break;
            case "Orders":
                element = new OrdersEntity();
                if(request.getParameter("id") != null){
                    ((OrdersEntity) element).setId(Integer.parseInt(request.getParameter("id")));
                }
                Date date = null;
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                ((OrdersEntity) element).setDate(new java.sql.Date(date.getTime()));
                System.out.println(request.getParameter("isPaid"));
                boolean isPaid = request.getParameter("isPaid").equals("on") ? true : false;
                ((OrdersEntity) element).setPaid(isPaid);
                System.out.println(request.getParameter("isPaid"));
                System.out.println(((OrdersEntity) element).isPaid());
                ((OrdersEntity) element).setClientsByClientId((ClientsEntity) HibernateController.findElementById(Long.parseLong(request.getParameter("clientId")), "Clients"));
                break;
            case "Goods":
                element = new GoodsEntity();
                if(request.getParameter("id") != null){
                    ((GoodsEntity) element).setId(Integer.parseInt(request.getParameter("id")));
                }
                ((GoodsEntity) element).setManufacturer(request.getParameter("manufacturer"));
                ((GoodsEntity) element).setModel(request.getParameter("model"));
                ((GoodsEntity) element).setPrice(Double.parseDouble(request.getParameter("price")));
                if (request.getParameter("description") != null) {
                    ((GoodsEntity) element).setDescription(request.getParameter("description"));
                }
                break;
            case "OrderToGoods":
                element = new OrderToGoodsEntity();
                if(request.getParameter("id") != null){
                    ((OrderToGoodsEntity) element).setId(Integer.parseInt(request.getParameter("id")));
                }
                ((OrderToGoodsEntity) element).setGoodsByGoodsId((GoodsEntity) HibernateController.findElementById(Long.parseLong(request.getParameter("goodsId")), "Goods"));
                ((OrderToGoodsEntity) element).setOrdersByOrderId((OrdersEntity) HibernateController.findElementById(Long.parseLong(request.getParameter("orderId")), "Orders"));
                ((OrderToGoodsEntity) element).setQuantity(Long.parseLong(request.getParameter("quantity")));
                break;
        }
        return element;
    }
}
