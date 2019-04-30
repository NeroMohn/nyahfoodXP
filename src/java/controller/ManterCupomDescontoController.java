/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CupomDesconto;
import dao.CupomDescontoDAO;

/**
 *
 * @author David
 */
@WebServlet(name = "ManterCupomDescontoController", urlPatterns = "/controller.ManterCupomDescontoController")
public class ManterCupomDescontoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            if (!operacao.equals("Incluir")) {
                Long idCupomDesconto = Long.parseLong(request.getParameter("idCupomDesconto"));
                CupomDesconto cupomDesconto = CupomDescontoDAO.getInstance().getCupomDesconto(idCupomDesconto);
                request.setAttribute("cupomDesconto", cupomDesconto);
            }
            RequestDispatcher view = request.getRequestDispatcher("/ManterCupomDesconto.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ManterCupomDescontoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManterCupomDescontoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String operacao = request.getParameter("operacao");
        String nome = request.getParameter("nome");
        Double valor = Double.parseDouble(request.getParameter("valor"));
        Integer ativo = Integer.parseInt(request.getParameter("ativo"));
        Long id = null;

        if (!operacao.equals("Incluir")) {
            id = Long.parseLong(request.getParameter("id"));
        }

        try {
            CupomDesconto cupomDesconto = new CupomDesconto(nome, valor, ativo);
            if (operacao.equals("Incluir")) {
                cupomDesconto.salvar();
            } else if (operacao.equals("Editar")) {
                cupomDesconto.setId(id);
                cupomDesconto.salvar();
            } else if (operacao.equals("Excluir")) {
                cupomDesconto.setId(id);
                cupomDesconto.excluir();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaCupomDescontoController");

            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
