/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.Comida;
import model.Loja;
import dao.ComidaDAO;

/**
 *
 * @author David
 */
@WebServlet(name = "ManterComidaController", urlPatterns = {"ManterComidaController"})
public class ManterComidaController extends HttpServlet {

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
            String tipo = request.getSession().getAttribute("tipo").toString();
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("tipo", tipo);
            if (tipo != "2") {
                RequestDispatcher view = request.getRequestDispatcher("AcessoNegadoController");
                view.forward(request, response);
            } else {
                if (!operacao.equals("Incluir")) {

                    Long idComida = Long.parseLong(request.getParameter("idComida"));
                    Comida comida = ComidaDAO.getInstance().getComida(idComida);
                    request.setAttribute("comida", comida);
                }
                RequestDispatcher view = request.getRequestDispatcher("/ManterComida.jsp");
                view.forward(request, response);
            }

        } catch (ServletException | IOException ex) {
            Logger.getLogger(ManterComidaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String operacao = request.getParameter("operacao");
        String nome = request.getParameter("txtNome");
        String ingrediente = request.getParameter("txtIngrediente");
        Integer tempoEstimado = Integer.parseInt(request.getParameter("txtTempoEstimado"));
        String foto = request.getParameter("txtFoto");
        Double preco = Double.parseDouble(request.getParameter("txtPreco"));

        Long codLoja = Long.parseLong(request.getSession().getAttribute("id").toString());

        try {

            if (operacao.equals("Incluir")) {
                Comida comida = new Comida(nome, ingrediente, tempoEstimado, foto, preco, codLoja);
                ComidaDAO.getInstance().salvar(comida);
            }/*else{ 
             if(operacao.equals("Editar")){
             Long idComida = Long.parseLong(request.getParameter("txtIdComida"));
             Comida comida = new Comida(idComida,nome,  ingrediente,  tempoEstimado,  foto,  preco, codLoja);
             comida.alterar();
             } else*/

            {
                if (operacao.equals("Excluir")) {
                    Long idComida = Long.parseLong(request.getParameter("txtIdComida"));
                    Comida comida;
                    comida = ComidaDAO.getInstance().getComida(idComida);
                    ComidaDAO.getInstance().excluir(comida);
                }
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaClienteController");
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
            Logger.getLogger(ManterComidaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterComidaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterComidaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterComidaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        @Override
        public String getServletInfo() {
        return "Short description";
    }
}
