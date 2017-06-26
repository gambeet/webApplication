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
            <label>Enter client's full name:</label> <input type="text" class="form-control" required style="width: 400px;" name="fio" value="<%=request.getParameter("fio")%>" required>
        </p>
        <p>
            <label>Enter client's address:</label> <input type="text"  class="form-control" required style="width: 400px;" name="address" value="<%=request.getParameter("address")%>" required>
        </p>
        <p>
            <label>Enter client's phone number:</label> <input type="text"  class="form-control" required style="width: 400px;" name="phone" value="<%=request.getParameter("phone")%>">
        </p>
        <input type="submit" name="add" class="btn btn-primary" value ="Edit">
    </form>
</div>
