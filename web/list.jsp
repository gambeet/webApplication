<%@ page import="model.EntityInterface" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="utils.HibernateSessionFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="utils.HibernateController" %>
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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/bootstrap/css/bootstrap.min.css">
    <script src="style/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<div id="header">
    Simple CRUD application
    <br>
    <div id="current">
        <%
            String currentTable = null;
            if (session.getAttribute("currentTable") != null) {
                currentTable = (String) session.getAttribute("currentTable");

        %>
        Current table: <%=currentTable %>
        <%}%>
    </div>
</div>
<div id="menue">
    <ul id="menu">
        <%
            if (session.getAttribute("currentTable") != null) {
        %>
        <li><a href="list.jsp">List</a></li>
        <li><a href="add.jsp">Add</a></li>
        <%}%>
        <ul id="choose">
            <li><a href=#>Choose table</a>
                <ul id="precident">
                    <li><a href="/ChooseTableServlet?tableName=Clients">Clients</a></li>
                    <li><a href="/ChooseTableServlet?tableName=Orders">Orders</a></li>
                    <li><a href="/ChooseTableServlet?tableName=OrderToGoods">OrderToGoods</a></li>
                    <li><a href="/ChooseTableServlet?tableName=Goods">Goods</a></li>
                </ul>
            </li>
        </ul>
    </ul>
</div>

<div id="list">
    <%
        List<EntityInterface> rows = HibernateController.read(currentTable);
    %>

    <table id="listTable" class="table table-hover">
        <% if (currentTable.equals("Clients")) {
        %>
        <thead>
        <tr>
            <th>Id</th>
            <th>Full name</th>
            <th>Address</th>
            <th>Phone</th>
            <th colspan="2"> Options</th>
        </tr>
        </thead>
        <%
            }
            if (currentTable.equals("Orders")) {
        %>
        <thead>
        <tr>
            <th>Id</th>
            <th>Date</th>
            <th>Is paid</th>
            <th>Client's name</th>
            <th colspan="2"> Options</th>
        </tr>
        </thead>
        <%
            }
            if (currentTable.equals("OrderToGoods")) {
        %>
        <thead>
        <tr>
            <th>Id</th>
            <th>Client</th>
            <th>Goods</th>
            <th>Goods quantity</th>
            <th colspan="2"> Options</th>
        </tr>
        </thead>
        <%
            }
            if (currentTable.equals("Goods")) {
        %>
        <thead>
        <tr>
            <th>Id</th>
            <th>Manufacturer</th>
            <th>Model</th>
            <th>Price</th>
            <th colspan="2"> Options</th>
        </tr>
        </thead>
        <%
            }%>
        <%for (EntityInterface row : rows) {%>
        <%=row.toHtmlTableRow()%>
        <%}%>
    </table>
</div>

</body>
</html>
