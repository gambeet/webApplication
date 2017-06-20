package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet(name = "/ChooseTableServlet")
public class getListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        HttpSession session = request.getSession();
        String currentTable = (String) session.getAttribute("currentTable");

    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        doGet(request,response);
    }

}
