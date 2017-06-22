package servlets;

import model.*;
import org.hibernate.Session;
import utils.HibernateSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class addElementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String currentTable = (String) session.getAttribute("currentTable");
        Session hibernateSession = HibernateSessionFactory.getSessionFactory().openSession();
        EntityInterface newElement = null;
        request.setCharacterEncoding("UTF-8");
        switch (currentTable) {
            case "Clients":
                newElement = new ClientsEntity();
                ((ClientsEntity) newElement).setAddress(request.getParameter("address"));
                ((ClientsEntity) newElement).setFio(request.getParameter("fio"));
                if (request.getParameter("phone") != null) {
                    ((ClientsEntity) newElement).setPhone(request.getParameter("phone"));
                }
                break;
            case "Orders":
                newElement = new OrdersEntity();
                Date date = null;
                try {
                    date = new SimpleDateFormat("DD/MM/YYYY").parse(request.getParameter("date"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                ((OrdersEntity) newElement).setDate(new java.sql.Date(date.getTime()));
                boolean isPaid = request.getParameter("isPaid").equals("on") ? true : false;
                ((OrdersEntity) newElement).setPaid(isPaid);
                System.out.println(request.getParameter("isPaid"));
                System.out.println(((OrdersEntity) newElement).isPaid());
                ((OrdersEntity) newElement).setClientsByClientId((ClientsEntity) findElementById(Long.parseLong(request.getParameter("clientId")), hibernateSession, "Clients"));
                break;
            case "Goods":
                newElement = new GoodsEntity();
                ((GoodsEntity) newElement).setManufacturer(request.getParameter("manufacturer"));
                ((GoodsEntity) newElement).setModel(request.getParameter("model"));
                ((GoodsEntity) newElement).setPrice(Double.parseDouble(request.getParameter("price")));
                if (request.getParameter("description") != null) {
                    ((GoodsEntity) newElement).setDescription(request.getParameter("description"));
                }
                break;
            case "OrderToGoods":
                newElement = new OrderToGoodsEntity();
                ((OrderToGoodsEntity) newElement).setGoodsByGoodsId((GoodsEntity) findElementById(Long.parseLong(request.getParameter("goodsId")),hibernateSession, "Goods"));
                ((OrderToGoodsEntity) newElement).setOrdersByOrderId((OrdersEntity) findElementById(Long.parseLong(request.getParameter("orderId")), hibernateSession, "Orders"));
                ((OrderToGoodsEntity) newElement).setQuantity(Long.parseLong(request.getParameter("quantity")));
                break;
        }
        hibernateSession.save(newElement);
        System.out.println(newElement.toHtmlTableRow());
        hibernateSession.close();
        response.sendRedirect("list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    private EntityInterface findElementById(long id, Session hibernateSession, String tableName){
        List<EntityInterface> list = (List<EntityInterface>) hibernateSession.createNamedQuery(tableName + ".findAll").list();
        for (EntityInterface row : list) {
            if (row.getId() == id) {
                return row;
            }
        }
        return null;
    }

}
