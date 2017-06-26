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
<div>
    <form action="EditElementServlet" method="POST">
        <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
        <p>
            <label>Choose client:</label>
            <select name="clientId" class="form-control" style="width: 400px;" value="<%=request.getParameter("clientId")%>">
                <%
                    List<ClientsEntity> rows = null;
                    Session hibernateSession = HibernateSessionFactory.getSessionFactory().openSession();
                    Query query = hibernateSession.createNamedQuery("Clients.findAll");
                    rows = (List<ClientsEntity>)query.list();
                    for (ClientsEntity row : rows) {%>
                <option value="<%=row.getId()%>" style="width: auto;">
                    <%=row.getFio()+ " | " + row.getAddress()%>
                </option>
                <%}%>
            </select>
        </p>
        <p>
            <label>Is order paid already?</label> <input type="checkbox" class="checkbox-inline" name="isPaid" <%=request.getParameter("isPaid")%>>
        </p>
        <p>
            <label>Choose order's date:</label><br> <input type="text" name="date" style="width: 400px;" class="datepicker" value="<%=request.getParameter("date")%>"  required>
        </p>
        <input type="submit" name="add" class="btn btn-primary" value="Edit">
    </form>
</div>
