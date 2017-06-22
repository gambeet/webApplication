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
            Enter client's full name <input type="text" name="fio" required>
        </p>
        <p>
            Enter client's address <input type="text" name="address" required>
        </p>
        <p>
            Enter client's phone number <input type="text" name="phone">
        </p>
        <input type="submit" name="add" value ="Add">
    </form>
</div>
