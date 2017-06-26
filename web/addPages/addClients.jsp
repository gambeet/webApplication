<%--
  Created by IntelliJ IDEA.
  User: Yevhenii
  Date: 20.06.2017
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <form action="AddElementServlet" method="post">
        <p>
           <label>Enter client's full name:</label>  <input type="text" class="form-control" name="fio" required style="width: 400px;">
        </p>
        <p>
            <label>Enter client's address:</label>  <input type="text" class="form-control" name="address" required style="width: 400px;">
        </p>
        <p>
            <label>Enter client's phone number:</label>  <input type="text" class="form-control" name="phone" style="width: 400px;">
        </p>
        <input type="submit" class="btn btn-primary" name="add" value ="Add">
    </form>
</div>
