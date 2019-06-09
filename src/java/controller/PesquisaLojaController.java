package controller;

import dao.GeralDAO;
import model.Loja;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PesquisaLojaController", urlPatterns = {"/PesquisaLojaController"})
public class PesquisaLojaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        List<Object> obterTodasLojas = GeralDAO.getInstance().getAllObjetos(Class.forName("model.Loja"));
        if (obterTodasLojas.isEmpty()) {
            request.setAttribute("vazio", "Sem Lojas");
        }
        String id = request.getSession().getAttribute("id").toString();
        request.setAttribute("id", id);
        request.setAttribute("lojas", obterTodasLojas);
        RequestDispatcher view = request.getRequestDispatcher("/PesquisaLoja.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisaLojaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisaLojaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getServletInfo() {
        return "Short description";
    }
}
