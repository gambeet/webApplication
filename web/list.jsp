<%@ page import="model.EntityInterface" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="utils.HibernateSessionFactory" %>
<%@ page import="java.util.List" %>
<%--
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
    if (session.getAttribute("currentTable") != null) {
        currentTable = (String) session.getAttribute("currentTable");
%>
<p>
    Current table: <%=currentTable %>
</p>
<%
    }
%>
<div>
    <%

        List<EntityInterface> rows = null;
        Session hibernateSession = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = null;
        query = hibernateSession.createNamedQuery(currentTable + ".findAll");
        /*switch (currentTable){
            case "Clients":
                query = hibernateSession.createNamedQuery("Clients.findAll");
                break;
            case "Orders":
                query = hibernateSession.createNamedQuery("Orders.findAll");
                break;
            case "Goods":
                query = hibernateSession.createNamedQuery("Goods.findAll");
                break;
            case "OrderToGoods":
                query = hibernateSession.createNamedQuery("OrderToGoods.findAll");
                break;
        }*/
        rows = query.list();
        //HibernateSessionFactory.shutdown();
    %>
    <table>
        <%for (EntityInterface row : rows) {%>
        <%=row.toHtmlTableRow()%>
        <%}%>
    </table>
</div>
<a href="list.jsp">List</a>
<a href="add.jsp">Add</a>
</body>
</html>
