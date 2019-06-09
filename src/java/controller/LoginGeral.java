package controller;

import dao.GeralDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Loja;

/**
 *
 * @author rodri
 */
@WebServlet(name = "LoginGeral", urlPatterns = {"/LoginGeral"})
public class LoginGeral extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("preparar")) {
            prepararOperacao(request, response);
        } else if (acao.equals("logar")) {
            logar(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginGeral.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginGeral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginGeral.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginGeral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void logar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        Cliente cliente = (Cliente)GeralDAO.getInstance().getClienteEmail(login, Class.forName("model.Cliente"), "email");
        Loja loja = (Loja)GeralDAO.getInstance().getClienteEmail(login, Class.forName("model.Loja"),"email");

        if (cliente == null && loja == null) {
            try {
                RequestDispatcher view = request.getRequestDispatcher("/SenhaIncorreta.jsp");
                view.forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger(LoginGeral.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (cliente != null) {

            if (senha.equals(cliente.getSenha()) && login.equals(cliente.getEmail())) {

                Long idCliente = cliente.getId();
                String nomeCliente = cliente.getNome();
                request.getSession().setAttribute("login", login);
                request.getSession().setAttribute("tipo", "1");
                request.getSession().setAttribute("id", idCliente);
                request.getSession().setAttribute("nome", nomeCliente);
                request.getSession().setAttribute("status", 0);
                RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                view.forward(request, response);
            } else {

                RequestDispatcher view = request.getRequestDispatcher("/SenhaIncorreta.jsp");
                view.forward(request, response);
            }
        } else if (loja != null) {
            if (senha.equals(loja.getSenha()) && login.equals(loja.getEmail())) {

                request.getSession().setAttribute("login", login);
                request.getSession().setAttribute("senha", senha);
                request.getSession().setAttribute("tipo", "2");
                request.getSession().setAttribute("id", loja.getId());
                RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                view.forward(request, response);
            } else {
                try {
                    RequestDispatcher view = request.getRequestDispatcher("/SenhaIncorreta.jsp");
                    view.forward(request, response);
                } catch (IOException ex) {
                    Logger.getLogger(LoginGeral.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher view = request.getRequestDispatcher("/LoginGeral.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(LoginGeral.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginGeral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
