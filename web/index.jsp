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
<p>testing commit and push from Ness-pc</p>
<%
    String currentTable = null;
    if (session.getAttribute("currentTable") != null) {
        currentTable = (String) session.getAttribute("currentTable");

%>
<p>
    Current table: <%=currentTable %>
</p>

<a href="list.jsp">List</a>
<a href="add.jsp">Add</a>
<%}%>
</body>
</html>
