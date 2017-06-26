<%--
  Created by IntelliJ IDEA.
  User: Yevhenii
  Date: 20.06.2017
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <title>Add Element</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="style/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="style/bootstrap/css/bootstrap-datepicker.min.css">
    <script src="style/bootstrap/js/bootstrap.min.js"></script>
    <script src="style/bootstrap/js/bootstrap-datepicker.min.js"></script>
    <script>
        $( function() {
            $( ".datepicker" ).datepicker({ format: 'yyyy-mm-dd' });
        } );
    </script>
    <link rel="stylesheet" href="http://htmlbook.ru/mysite.css">
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
<div id="add">
<%
    if (session.getAttribute("currentTable") != null) {
        currentTable = (String) session.getAttribute("currentTable");
    }
    String includePage = "addPages/add" + currentTable + ".jsp";
%>
<jsp:include page="<%=includePage%>"></jsp:include>
</div>
</body>
</html>
