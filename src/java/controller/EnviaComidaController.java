package controller;

import dao.GeralDAO;

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
import model.ComidaPedida;

@WebServlet(name = "EnviaComidaController", urlPatterns = {"/EnviaComidaController"})
public class EnviaComidaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {

        List<Object> obterTodasComidas = GeralDAO.getInstance().getAllObjetos(Class.forName("model.Comida"));
        if (obterTodasComidas.isEmpty()) {
            request.setAttribute("vazio", "Mensagem");
        }
        Long id = Long.parseLong(request.getParameter("id"));
        ComidaPedida comidaPedida = (ComidaPedida) GeralDAO.getInstance().getObjeto(id, Class.forName("model.ComidaPedida"));
        comidaPedida.setSaiuEntrega("Saiu Entrega");
        comidaPedida.salvar();

        RequestDispatcher view = request.getRequestDispatcher("/PesquisaComidaPedidaController");
        view.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EnviaComidaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EnviaComidaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
