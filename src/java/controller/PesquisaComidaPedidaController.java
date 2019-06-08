package controller;

import dao.ComidaPedidaDAO;
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

@WebServlet(name = "PesquisaComidaPedidaController", urlPatterns = {"/PesquisaComidaPedidaController"})
public class PesquisaComidaPedidaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        List<Object> obterTodasComidasPedidas = GeralDAO.getInstance().getAllObjetos(Class.forName("model.ComidaPedida"));
        if (obterTodasComidasPedidas.isEmpty()) {
            request.setAttribute("vazio", "Mensagem");
        }
        String id = request.getSession().getAttribute("id").toString();
        request.setAttribute("id", id);
        request.setAttribute("comidasPedidas", obterTodasComidasPedidas);
        RequestDispatcher view = request.getRequestDispatcher("/PesquisaPedido.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisaComidaPedidaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisaComidaPedidaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getServletInfo() {
        return "Short description";
    }
}
