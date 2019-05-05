package controller;

import dao.LojaDAO;
import model.Loja;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PesquisaLojaControllerADM", urlPatterns = {"/PesquisaLojaControllerADM"})
public class PesquisaLojaControllerADM extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Loja> obterTodasLojas = LojaDAO.getInstance().getAllLojas();
        if(obterTodasLojas.isEmpty()){
            request.setAttribute("vazio", "Mensagem");
        }
        String id = request.getSession().getAttribute("id").toString();
        request.setAttribute("id",id);
        request.setAttribute("lojas", LojaDAO.getInstance().getAllLojas());
        RequestDispatcher view = request.getRequestDispatcher("/PesquisaLojaADM.jsp");
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