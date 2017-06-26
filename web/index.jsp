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
        <li><a href=="list.jsp">List</a></li>
        <li><a href="add.jsp">Add</a></li>
        <%}%>
        <ul id="choose">
            <li><a href=#>Choose table</a>
                <ul id="precident">
                    <li><a href="/ChooseTableServlet?tableName=Clients">Clients</a></li>
                    <li><a href="/ChooseTableServlet?tableName=Orders">Orders</a></li>
                    <li><a href="/ChooseTableServlet?tableName=Goods">OrderToGoods</a></li>
                    <li><a href="/ChooseTableServlet?tableName=OrderToGoods">Goods</a></li>
                </ul>
            </li>
        </ul>
    </ul>
</div>

</body>
</html>
