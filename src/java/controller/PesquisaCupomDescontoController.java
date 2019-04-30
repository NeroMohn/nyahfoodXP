package controller;

import dao.CupomDescontoDAO;
import model.CupomDesconto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Yukas
 */
@WebServlet(name = "PesquisaCupomDescontoController", urlPatterns = {"/PesquisaCupomDescontoController"})
public class PesquisaCupomDescontoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<CupomDesconto> obterTodosCuponsDesconto = CupomDescontoDAO.getInstance().getAllCupomDescontos();
        if (obterTodosCuponsDesconto.isEmpty()) {
            request.setAttribute("vazio", "Mensagem");
        }
        request.setAttribute("cuponsDesconto", CupomDescontoDAO.getInstance().getAllCupomDescontos());
        RequestDispatcher view = request.getRequestDispatcher("/PesquisaCupomDesconto.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
