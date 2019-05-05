package controller;

import dao.ComidaDAO;
import dao.ComidaPedidaDAO;
import dao.LojaDAO;
import dao.PedidoDAO;
import model.Comida;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.ComidaPedida;
import model.Pedido;

@WebServlet(name = "EnviaComidaController", urlPatterns = {"/EnviaComidaController"})
public class EnviaComidaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        List<Pedido> obterTodasComidas = PedidoDAO.getInstance().getAllPedidos();
        if(obterTodasComidas.isEmpty()){
            request.setAttribute("vazio", "Mensagem");
        }
        Long id = Long.parseLong(request.getParameter("id"));
        ComidaPedida comidaPedida = ComidaPedidaDAO.getInstance().getComidaPedida(id);
        comidaPedida.setSaiuEntrega("Saiu Entrega");
        comidaPedida.salvar();
       
        RequestDispatcher view = request.getRequestDispatcher("/PesquisaComidaPedidaController");
        view.forward(request, response);
   
       
     
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
