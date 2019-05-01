package controller;

import dao.TipoCozinhaDAO;
import model.TipoCozinha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class PesquisaTipoCozinhaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TipoCozinha> obterTodosTiposCozinha = TipoCozinhaDAO.getInstance().getAllTipoCozinhas();
        if(obterTodosTiposCozinha.isEmpty()){
            request.setAttribute("vazio", "Mensagem");
        }
        request.setAttribute("tiposcozinhas", obterTodosTiposCozinha);
        RequestDispatcher view = request.getRequestDispatcher("/PesquisaTipoCozinha.jsp");
        view.forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }
}