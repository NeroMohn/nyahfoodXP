/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import dao.CupomDescontoDAO;
import dao.PedidoDAO;
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
import model.CupomDesconto;
import model.Pedido;

/**
 *
 * @author Yukas
 */
@WebServlet(name = "ManterPedidoController", urlPatterns = "/ManterPedidoController")

public class ManterPedidoController extends HttpServlet {

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
            request.setAttribute("clientes", ClienteDAO.getInstance().getAllClientes());
            String tipo = request.getSession().getAttribute("tipo").toString();

            if (tipo != "3") {
                RequestDispatcher view = request.getRequestDispatcher("AcessoNegadoController");
                view.forward(request, response);
            } else {
                if (!operacao.equals("Incluir")) {
                    Long idPedido = Long.parseLong(request.getParameter("idPedido"));
                    Pedido pedido = PedidoDAO.getInstance().getPedido(idPedido);
                    request.setAttribute("pedido", pedido);

                }
            }
            RequestDispatcher view = request.getRequestDispatcher("/ManterPedido.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
        String operacao = request.getParameter("operacao");
        Double total = Double.parseDouble(request.getParameter("txtTotal"));
        String metodoPagamento = request.getParameter("txtMetodoPagamento");
        String date = request.getParameter("txtDate");
        Long codCliente = Long.parseLong(request.getSession().getAttribute("id").toString());
        Cliente cliente = ClienteDAO.getInstance().getCliente(codCliente);
        Long codCupomDesconto = Long.parseLong(request.getParameter("txtCodCupomDesconto"));
        CupomDesconto cupomDesconto = CupomDescontoDAO.getInstance().getCupomDesconto(codCupomDesconto);

        if (operacao.equals("Incluir")) {
            Pedido pedido;
            pedido = new Pedido(total, metodoPagamento, date, cliente, cupomDesconto);
            PedidoDAO.getInstance().salvar(pedido);
        } else {
            if (operacao.equals("Editar")) {
                Long idPedido = Long.parseLong(request.getParameter("txtIdPedido"));
                Pedido pedido = PedidoDAO.getInstance().getPedido(idPedido);
                PedidoDAO.getInstance().salvar(pedido);
            } else {
                if (operacao.equals("Excluir")) {
                    Long idPedido = Long.parseLong(request.getParameter("txtIdPedido"));
                    Pedido pedido = PedidoDAO.getInstance().getPedido(idPedido);
                    PedidoDAO.getInstance().excluir(pedido);
                }
            }
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
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
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
