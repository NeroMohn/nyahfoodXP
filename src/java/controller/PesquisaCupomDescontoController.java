package controller;

import TesteSobra.CupomDescontoDAO;
import dao.GeralDAO;
import model.CupomDesconto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yukas
 */
@WebServlet(name = "PesquisaCupomDescontoController", urlPatterns = {"/PesquisaCupomDescontoController"})
public class PesquisaCupomDescontoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        List<Object> obterTodosCuponsDesconto = GeralDAO.getInstance().getAllObjetos(Class.forName("model.CupomDesconto"));
        if (obterTodosCuponsDesconto.isEmpty()) {
            request.setAttribute("vazio", "Mensagem");
        }
        request.setAttribute("cuponsDesconto", obterTodosCuponsDesconto);
        RequestDispatcher view = request.getRequestDispatcher("/PesquisaCupomDesconto.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisaCupomDescontoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisaCupomDescontoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
