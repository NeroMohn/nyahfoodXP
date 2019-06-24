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
import model.Loja;
import model.TipoCozinha;

/**
 *
 * @author David
 */
@WebServlet(name = "CadastroLojaController", urlPatterns = "/CadastroLojaController")
public class CadastroLojaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")) {
                prepararOperacao(request, response);
            }
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("tiposCozinha", GeralDAO.getInstance().getAllObjetos(Class.forName("model.TipoCozinha")));
            if (!operacao.equals("Incluir")) {
                Long idLoja = Long.parseLong(request.getParameter("idLoja"));
                Loja loja = (Loja) GeralDAO.getInstance().getObjeto(idLoja, Class.forName("model.Loja"));
                request.setAttribute("loja", loja);
            }
            RequestDispatcher view = request.getRequestDispatcher("/CadastroLoja.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(CadastroLojaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadastroLojaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException {
        String operacao = request.getParameter("operacao");
        String nome = request.getParameter("txtNomeLoja");
        String nomeGerente = request.getParameter("txtNomeGerenteLoja");
        String email = request.getParameter("txtEmailLoja");
        String senha = request.getParameter("txtSenhaLoja");
        String telefone = request.getParameter("txtTelefoneLoja");
        String cnpj = request.getParameter("txtCnpjLoja");
        String descricao = request.getParameter("txtDescricaoLoja");
        Long codTipoCozinha = Long.parseLong(request.getParameter("optTipoCozinha"));
        TipoCozinha tipoCozinha = (TipoCozinha) GeralDAO.getInstance().getObjeto(codTipoCozinha, Class.forName("model.TipoCozinha"));
       
        String cep = request.getParameter("txtCepLoja");
        String logradouro = request.getParameter("txtLogradouroLoja");
        String bairro = request.getParameter("txtBairroLoja");
        String numero = request.getParameter("txtNumeroLoja");
        String complemento = request.getParameter("txtComplementoLoja");
        String cidade = request.getParameter("txtCidadeLoja");
        String estado = request.getParameter("txtEstadoLoja");
        Long id = null;

        if (!operacao.equals("Incluir")) {
            id = Long.parseLong(request.getParameter("txtIdLoja"));
        }

        try {
            Loja loja = new Loja(nome, nomeGerente, email, senha, telefone, cnpj,
                    descricao, tipoCozinha, cep, logradouro, bairro, numero,
                    complemento, cidade, estado);
            Object objeto = loja;

            if (operacao.equals("Incluir")) {
                GeralDAO.getInstance().salvar(objeto);
            } else if (operacao.equals("Editar")) {
                loja.setId(id);
                GeralDAO.getInstance().salvar(objeto);
            } else if (operacao.equals("Excluir")) {
                loja.setId(id);
                GeralDAO.getInstance().excluir(objeto);

            }
            RequestDispatcher view = request.getRequestDispatcher("LoginGeral.jsp");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(CadastroLojaController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroLojaController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(CadastroLojaController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroLojaController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
