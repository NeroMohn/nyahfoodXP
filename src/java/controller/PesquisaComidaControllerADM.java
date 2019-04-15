package controller;

import model.Comida;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import static model.Comida.obterTodasComidas;

@WebServlet(name = "PesquisaComidaControllerADM", urlPatterns = {"/PesquisaComidaControllerADM"})
public class PesquisaComidaControllerADM extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipo = request.getSession().getAttribute("tipo").toString();
        if (tipo == "3"){
        try {
            List<Comida> obterTodasComidas = Comida.obterTodasComidas();
            if(obterTodasComidas.isEmpty()){
                request.setAttribute("vazio","");
            }
            request.setAttribute("comidas", obterTodasComidas());
            RequestDispatcher view = request.getRequestDispatcher("/PesquisaComidaADM.jsp");
            view.forward(request, response);

        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        }}else{
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
