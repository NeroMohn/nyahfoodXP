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

@WebServlet(name = "PesquisaClienteControllerADM", urlPatterns = {"/PesquisaClienteControllerADM"})

public class PesquisaClienteControllerADM extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        String tipo = request.getSession().getAttribute("tipo").toString();
        if (tipo == "3") {
            List<Object> obterTodosClientes = GeralDAO.getInstance().getAllObjetos(Class.forName("model.Cliente"));
            if (obterTodosClientes.isEmpty()) {
                request.setAttribute("vazio", "");
            }
            request.setAttribute("clientes", obterTodosClientes);
            RequestDispatcher view = request.getRequestDispatcher("/PesquisaClienteADM.jsp");
            view.forward(request, response);
        } else {
            RequestDispatcher view = request.getRequestDispatcher("/AcessoNegado.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisaClienteControllerADM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisaClienteControllerADM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
