/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import dao.CupomDescontoDAO;
import dao.GeralDAO;
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

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException {
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
                    Long idPedido = Long.parseLong(request.getParameter("id"));
                    Pedido pedido;
                    try {
                        pedido = (Pedido) GeralDAO.getInstance().getObjeto(idPedido, Class.forName("model.Pedido"));
                        request.setAttribute("pedido", pedido);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                 
                }
                   RequestDispatcher view = request.getRequestDispatcher("/ManterPedido.jsp");
                    view.forward(request, response);
            }
      
        } catch (ServletException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException {
        String operacao = request.getParameter("operacao");
        Double total = Double.parseDouble(request.getParameter("txtTotal"));
        String metodoPagamento = request.getParameter("txtMetodoPagamento");
        String date = request.getParameter("txtDate");
        
        Long idPedido = Long.parseLong(request.getParameter("txtIdPedido"));
        Pedido pedidop = PedidoDAO.getInstance().getPedido(idPedido);
        Long idCliente = Long.parseLong(request.getParameter("optCliente"));
        Cliente cliente = ClienteDAO.getInstance().getCliente(idCliente);
        //Long codCupomDesconto = Long.parseLong(request.getParameter("txtCodCupomDesconto"));
       // CupomDesconto cupomDesconto = CupomDescontoDAO.getInstance().getCupomDesconto(codCupomDesconto);
        Long id = null;

        if (!operacao.equals("Incluir")) {
            id = Long.parseLong(request.getParameter("txtIdPedido"));
        }

        try {
            Pedido pedido = new Pedido(total, metodoPagamento, date, cliente, null);
            Object objeto = pedido;
            if (operacao.equals("Incluir")) {
                pedido.setId(id);
                GeralDAO.getInstance().salvar(objeto);
            } else if (operacao.equals("Editar")) {
                pedido.setId(id);
                GeralDAO.getInstance().salvar(objeto);
            } else if (operacao.equals("Excluir")) {
               pedido.setId(id);
               GeralDAO.getInstance().excluir(objeto);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPedidoControllerADM");
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
            Logger.getLogger(ManterPedidoController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPedidoController.class
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
            Logger.getLogger(ManterPedidoController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPedidoController.class
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
