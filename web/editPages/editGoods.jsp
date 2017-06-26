<%--
  Created by IntelliJ IDEA.
  User: Yevhenii
  Date: 20.06.2017
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <form action="EditElementServlet" method="POST">
        <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
        <p>
            <label>Enter goods manufacturer:</label> <input type="text" name="manufacturer" class="form-control"  style="width: 400px;" value="<%=request.getParameter("manufacturer")%>" required>
        </p>
        <p>
            <label> Enter goods model:</label> <input type="text" name="model" class="form-control"  style="width: 400px;" value="<%=request.getParameter("model")%>" required>
        </p>
        <p>
            <label>Enter goods price:</label> <input type="number" step="0.01" min="0" class="form-control"  style="width: 400px;" name="price" value="<%=request.getParameter("price")%>" required>
        </p>
        <p>
            <label>Enter description:</label> <textarea name="description" class="form-control" required style="width: 400px; height: 100px;" value="<%=request.getParameter("description")%>"></textarea>
        </p>
        <input type="submit" name="add"  class="btn btn-primary" value="Edit">
    </form>
</div>
