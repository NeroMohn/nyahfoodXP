package controller;

import TesteSobra.ComidaDAO;
import dao.GeralDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "PesquisaComidaLojaController", urlPatterns = {"/PesquisaComidaLojaController"})
public class PesquisaComidaLojaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {

        String id = request.getSession().getAttribute("id").toString();
        request.setAttribute("id", id);
        request.setAttribute("comidas", GeralDAO.getInstance().getAllObjetos(Class.forName("model.Comida")));
        RequestDispatcher view = request.getRequestDispatcher("/PesquisaComidaLoja.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisaComidaLojaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisaComidaLojaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
