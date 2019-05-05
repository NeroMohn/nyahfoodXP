package controller;

import dao.LojaDAO;
import dao.TipoCozinhaDAO;
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
 * @author Yukas
 */
@WebServlet(name = "ManterLojaController", urlPatterns = "/ManterLojaController")
public class ManterLojaController extends HttpServlet {

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

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) {
        try {

            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("tiposCozinha", TipoCozinhaDAO.getInstance().getAllTipoCozinhas());
            if (!operacao.equals("Incluir")) {
                Long idLoja = Long.parseLong(request.getParameter("id"));
                Loja loja = LojaDAO.getInstance().getLoja(idLoja);
                request.setAttribute("loja", loja);

            }
            RequestDispatcher view = request.getRequestDispatcher("/ManterLoja.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ManterLojaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManterLojaController.class.getName()).log(Level.SEVERE, null, ex);
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
        TipoCozinha tipoCozinha = TipoCozinhaDAO.getInstance().getTipoCozinha(codTipoCozinha);
        String foto = request.getParameter("txtFotoLoja");
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
            Loja loja = new Loja(nome, nomeGerente, telefone, email,
                    senha, cnpj, descricao, tipoCozinha,
                    foto, cep, logradouro,
                    bairro, complemento, cidade, estado,
                    numero);
            if (operacao.equals("Incluir")) {
                loja.salvar();
            } else if (operacao.equals("Editar")) {
                // if(request.getSession().getAttribute("id")!=null)
                //  String idLoja1 = (String)request.getSession().getAttribute("id");
                loja.setId(id);
                loja.salvar();
            } else if (operacao.equals("Excluir")) {
                loja.setId(id);
                loja.excluir();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaLojaControllerADM");

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
            Logger.getLogger(ManterLojaController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterLojaController.class
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
            Logger.getLogger(ManterLojaController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterLojaController.class
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

    private Long parseLong(Long idLoja1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
