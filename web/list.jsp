<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.boot.registry.StandardServiceRegistry" %>
<%@ page import="org.hibernate.boot.registry.StandardServiceRegistryBuilder" %>
<%@ page import="org.hibernate.boot.MetadataSources" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="java.util.Properties" %>
<%@ page import="org.hibernate.service.ServiceRegistry" %>
<%@ page import="java.util.List" %>
<%@ page import="model.ClientsEntity" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.hibernate.HibernateException" %>
<%@ page import="utils.HibernateSessionFactory" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="model.EntityInterface" %><%--
  Created by IntelliJ IDEA.
  User: Yevhenii
  Date: 19.06.2017
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="style/style.css">
</head>
<body>

<ul class="menu">
    <li><a href=#>Menu 1</a>
        <ul class="submenu">
            <li><a href="/ChooseTableServlet?tableName=Clients">Clients</a></li>
            <li><a href="/ChooseTableServlet?tableName=Orders">Orders</a></li>
            <li><a href="/ChooseTableServlet?tableName=Goods">Goods</a></li>
            <li><a href="/ChooseTableServlet?tableName=OrderToGoods">OrderToGoods</a></li>
        </ul>
    </li>
</ul>

<%
    String currentTable = null;
    if(session.getAttribute("currentTable") != null){
        currentTable = (String) session.getAttribute("currentTable");
    }
%>
<p>
    Current table: <%=currentTable %>
</p>

<div>
    <%

        List<EntityInterface> rows = null;
        Session session1 = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = null;
        switch (currentTable){
            case "Clients":
                query = session1.createNamedQuery("Clients.findAll");
                break;
            case "Orders":
                query = session1.createNamedQuery("Orders.findAll");
                break;
            case "Goods":
                query = session1.createNamedQuery("Goods.findAll");
                break;
            case "OrderToGoods":
                query = session1.createNamedQuery("OrderToGoods.findAll");
                break;
        }
        rows = query.list();
    %>
    <table>
        <%for (EntityInterface row : rows) {%>
            <%=row.toHtmlTableRow()%>
        <%}%>
    </table>
</div>
<a href="list.jsp">List</a>
</body>
</html>
