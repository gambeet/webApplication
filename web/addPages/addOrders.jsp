<%@ page import="model.EntityInterface" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="java.util.List" %>
<%@ page import="utils.HibernateSessionFactory" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="model.ClientsEntity" %><%--
  Created by IntelliJ IDEA.
  User: Yevhenii
  Date: 20.06.2017
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-group">
    <form action="AddElementServlet" method="POST">
        <p>
            <label>Choose client:</label>
            <select name="clientId" class="form-control" style="width: 400px;">
                <%
                    List<ClientsEntity> rows = null;
                    Session hibernateSession = HibernateSessionFactory.getSessionFactory().openSession();
                    Query query = hibernateSession.createNamedQuery("Clients.findAll");
                    rows = (List<ClientsEntity>) query.list();
                    for (ClientsEntity row : rows) {%>
                <option value="<%=row.getId()%>" style="width: auto;">
                    <%=row.getFio() + " | " + row.getAddress()%>
                </option>
                <%}%>
            </select>
        </p>
        <p>
            <label>Is order paid already?</label>
            <input type="checkbox" class="checkbox-inline" name="isPaid">
        </p>
        <p>
            <label>Choose order's date:</label>
            <input type="text" class="datepicker" name="date" readonly required>
        </p>
        <input type="submit" class="btn btn-primary" name="add" value="Add">
    </form>
</div>
