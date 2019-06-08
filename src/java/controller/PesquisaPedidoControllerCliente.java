package controller;

import dao.GeralDAO;
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

@WebServlet(name = "PesquisaPedidoControllerCliente", urlPatterns = {"/PesquisaPedidoControllerCliente"})
public class PesquisaPedidoControllerCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        List<Object> obterTodosPedidos = GeralDAO.getInstance().getAllObjetos(Class.forName("model.Pedido"));
        if (obterTodosPedidos.isEmpty()) {
            request.setAttribute("vazio", "Mensagem");
        }
        request.setAttribute("pedidos", obterTodosPedidos);
        RequestDispatcher view = request.getRequestDispatcher("/PesquisaPedidoCliente.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisaPedidoControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisaPedidoControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getServletInfo() {
        return "Short description";
    }
}
