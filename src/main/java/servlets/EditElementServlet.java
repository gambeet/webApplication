package servlets;

import model.EntityInterface;
import utils.HibernateController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditElementServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String currentTable = (String) session.getAttribute("currentTable");
        request.setCharacterEncoding("UTF-8");
        EntityInterface editedElement = super.getElementFromRequest(request, currentTable);
        HibernateController.update(editedElement, currentTable);
        response.sendRedirect("list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
