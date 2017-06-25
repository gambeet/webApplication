<%--
  Created by IntelliJ IDEA.
  User: Yevhenii
  Date: 20.06.2017
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <%request.setCharacterEncoding("UTF-8");%>
    <form action="EditElementServlet" method="post">
        <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
        <p>
            Enter client's full name <input type="text" name="fio" value="<%=request.getParameter("fio")%>" required>
        </p>
        <p>
            Enter client's address <input type="text" name="address" value="<%=request.getParameter("address")%>" required>
        </p>
        <%
            System.out.println(request.getParameter("phone"));%>
        <p>
            Enter client's phone number <input type="text" name="phone" value="<%=request.getParameter("phone")%>">
        </p>
        <input type="submit" name="add" value ="Edit">
    </form>
</div>
