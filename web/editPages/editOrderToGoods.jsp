<%@ page import="model.OrdersEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="utils.HibernateSessionFactory" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="model.GoodsEntity" %><%--
  Created by IntelliJ IDEA.
  User: Yevhenii
  Date: 20.06.2017
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <%

        Session hibernateSession = HibernateSessionFactory.getSessionFactory().openSession();%>
    <form action="EditElementServlet" method="POST">
        <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
        <p>
            Choose order
            <select name="orderId" style="width: 200px;" value="<%=request.getParameter("orderId")%>">
                <%
                    List<OrdersEntity> orders = null;
                    Query queryOrders = hibernateSession.createNamedQuery("Orders.findAll");
                    orders = (List<OrdersEntity>)queryOrders.list();
                    for (OrdersEntity row : orders) {%>
                <option value="<%=row.getId()%>" style="width: auto;">
                    <%=row.getClientsByClientId().getFio()+ " | " + row.getDate()%>
                </option>
                <%}%>
            </select>
        </p>
        <p>
            Choose goods
            <select name="goodsId" style="width: 200px;" value="<%=request.getParameter("goodsId")%>">
                <%
                    List<GoodsEntity> goods = null;
                    Query queryGoods = hibernateSession.createNamedQuery("Goods.findAll");
                    goods = (List<GoodsEntity>)queryGoods.list();
                    for (GoodsEntity row : goods) {%>
                <option value="<%=row.getId()%>" style="width: auto;">
                    <%=row.getManufacturer()+ " " + row.getModel()%>
                </option>
                <%}%>
            </select>
        </p>
        <p>
            Enter number of goods <input type="number" name="quantity" min="1" value="1" value="<%=request.getParameter("quantity")%>">
        </p>
        <input type="submit" name="add" value="Add">
    </form>
</div>
