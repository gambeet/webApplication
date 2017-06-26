<%--
  Created by IntelliJ IDEA.
  User: Yevhenii
  Date: 20.06.2017
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <form action="AddElementServlet" method="POST">
        <p>
            <label>Enter goods manufacturer:</label> <input type="text" name="manufacturer"  class="form-control" style="width: 400px;" required>
        </p>
        <p>
            <label>Enter goods model:</label> <input type="text" name="model"  class="form-control" style="width: 400px;" required>
        </p>
        <p>
            <label>Enter goods price:</label> <input type="number" step="0.01" min="0" name="price" class="form-control" style="width: 400px;"required>
        </p>
        <p>
            <label>Enter description:</label> <textarea name="description" class="form-control" style="width: 400px; height: 100px;" ></textarea>
        </p>
        <input type="submit" name="add" class="btn btn-primary" value="Add">
    </form>
</div>
