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

@WebServlet(name = "PesquisaFavoritoController")
public class PesquisaFavoritoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        List<Object> obterTodosFavoritos = GeralDAO.getInstance().getAllObjetos(Class.forName("model.Favorito"));
        if (obterTodosFavoritos.isEmpty()) {
            request.setAttribute("vazio", "Mensagem");
        }
        request.setAttribute("favoritos", obterTodosFavoritos);
        RequestDispatcher view = request.getRequestDispatcher("/PesquisaFavorito.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisaFavoritoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PesquisaFavoritoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
