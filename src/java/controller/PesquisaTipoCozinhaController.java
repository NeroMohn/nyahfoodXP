package controller;

import dao.GeralDAO;
import TesteSobra.TipoCozinhaDAO;
import model.TipoCozinha;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PesquisaTipoCozinhaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        List<Object> obterTodosTiposCozinha = GeralDAO.getInstance().getAllObjetos(Class.forName("model.TipoCozinha"));
        if (obterTodosTiposCozinha.isEmpty()) {
            request.setAttribute("vazio", "Mensagem");
        }
        request.setAttribute("tiposcozinhas", obterTodosTiposCozinha);
        RequestDispatcher view = request.getRequestDispatcher("/PesquisaTipoCozinha.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisaTipoCozinhaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisaTipoCozinhaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getServletInfo() {
        return "Short description";
    }
}
