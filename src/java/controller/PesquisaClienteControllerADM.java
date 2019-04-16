package controller;

import dao.ClienteDAO;
import model.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PesquisaClienteControllerADM", urlPatterns = {"/PesquisaClienteControllerADM"})

public class PesquisaClienteControllerADM extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipo = request.getSession().getAttribute("tipo").toString();
        if (tipo == "3"){
            List<Cliente> obterTodosClientes = ClienteDAO.getInstance().getAllClientes();
            if (obterTodosClientes.isEmpty()) {
                request.setAttribute("vazio", "");
            }
            request.setAttribute("clientes", obterTodosClientes);
            RequestDispatcher view = request.getRequestDispatcher("/PesquisaClienteADM.jsp");
            view.forward(request, response);
}else{
            RequestDispatcher view = request.getRequestDispatcher("/AcessoNegado.jsp");
        }
    }
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}