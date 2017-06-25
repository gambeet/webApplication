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
            Enter goods manufacturer <input type="text" name="manufacturer" value="<%=request.getParameter("manufacturer")%>" required>
        </p>
        <p>
            Enter goods model <input type="text" name="model" value="<%=request.getParameter("model")%>" required>
        </p>
        <p>
            Enter goods price <input type="number" step="0.01" min="0" name="price" value="<%=request.getParameter("price")%>" required>
        </p>
        <p>
            Enter description <textarea name="description" value="<%=request.getParameter("description")%>"></textarea>
        </p>
        <input type="submit" name="add" value="Add">
    </form>
</div>
