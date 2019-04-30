package controller;

import dao.FavoritoDAO;
import model.Favorito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PesquisaFavoritoController")
public class PesquisaFavoritoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Favorito> obterTodosFavoritos = FavoritoDAO.getInstance().getAllFavoritos();
        if(obterTodosFavoritos.isEmpty()){
            request.setAttribute("vazio", "Mensagem");
        }
        request.setAttribute("favoritos", FavoritoDAO.getInstance().getAllFavoritos());
        RequestDispatcher view = request.getRequestDispatcher("/PesquisaFavorito.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
