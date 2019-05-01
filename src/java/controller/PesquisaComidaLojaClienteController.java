package controller;

import dao.ComidaDAO;
import model.Comida;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PesquisaComidaLojaClienteController", urlPatterns = {"/PesquisaComidaLojaClienteController"})
public class PesquisaComidaLojaClienteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
         String id = request.getSession().getAttribute("id").toString();
        request.setAttribute("id",id);
        request.setAttribute("comidas", ComidaDAO.getInstance().getAllComidas());
        RequestDispatcher view = request.getRequestDispatcher("/PesquisaComidaLojaCliente.jsp");
        view.forward(request, response);
       
     
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
