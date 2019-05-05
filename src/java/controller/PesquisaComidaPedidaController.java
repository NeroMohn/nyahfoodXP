package controller;

import dao.ComidaDAO;
import dao.ComidaPedidaDAO;
import dao.LojaDAO;
import model.ComidaPedida;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PesquisaComidaPedidaController", urlPatterns = {"/PesquisaComidaPedidaController"})
public class PesquisaComidaPedidaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ComidaPedida> obterTodasComidasPedidas = ComidaPedidaDAO.getInstance().getAllComidaPedidas();
        if (obterTodasComidasPedidas.isEmpty()) {
            request.setAttribute("vazio", "Mensagem");
        }
        
        String id = request.getSession().getAttribute("id").toString();
        request.setAttribute("id",id);
        request.setAttribute("comidasPedidas", ComidaPedidaDAO.getInstance().getAllComidaPedidas());
        RequestDispatcher view = request.getRequestDispatcher("/PesquisaPedido.jsp");
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