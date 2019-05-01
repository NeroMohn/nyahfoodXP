
/**
 *
 * @author David
 */
package controller;

import dao.PedidoDAO;
import model.Pedido;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PesquisaPedidoControllerADM", urlPatterns = {"/PesquisaPedidoControllerADM"})
public class PesquisaPedidoControllerADM extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pedido> obterTodosPedidos = PedidoDAO.getInstance().getAllPedidos();
        if(obterTodosPedidos.isEmpty()){
            request.setAttribute("vazio", "");
        }
        request.setAttribute("pedidos",obterTodosPedidos);
        RequestDispatcher view = request.getRequestDispatcher("/PesquisaPedidoADM.jsp");
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