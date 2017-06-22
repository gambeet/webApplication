package servlets;

import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class deleteElementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String currentTable = (String) session.getAttribute("currentTable");
        Session hibernateSession = HibernateSessionFactory.getSessionFactory().openSession();
        request.setCharacterEncoding("UTF-8");
        hibernateSession.beginTransaction();
        Query query =  hibernateSession.createNamedQuery(currentTable+".deleteElement");
        query.setParameter("id", Long.parseLong(request.getParameter("id")));
        query.executeUpdate();
        hibernateSession.close();
        response.sendRedirect("list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
