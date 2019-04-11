/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import dao.ComidaDAO;
import dao.ComidaPedidaDAO;
import dao.PedidoDAO;
import java.io.IOException;
import static java.lang.Long.parseLong;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Comida;
import model.ComidaPedida;
import model.Pedido;

/**
 *
 * @author David
 */

@WebServlet(name = "ManterComidaPedidaController", urlPatterns = {"/controller.ManterComidaPedidaController"})
public class ManterComidaPedidaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo = request.getSession().getAttribute("tipo").toString();
        String acao = request.getParameter("acao");
        if (tipo != "1") {
            RequestDispatcher view = request.getRequestDispatcher("AcessoNegadoController");
            view.forward(request, response);
        } else {

            if (acao.equals("confirmarOperacao")) {
                confirmarOperacao(request, response);
            } else {
                if (acao.equals("prepararOperacao")) {
                    prepararOperacao(request, response);

                }
            }
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) {
        try {

            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("comidas", ComidaDAO.getInstance().getAllComidas());
            request.setAttribute("pedidos", PedidoDAO.getInstance().getAllPedidos());
            Long idCliente = Long.parseLong(request.getSession().getAttribute("id").toString());

            String status = (request.getSession().getAttribute("status").toString());
            if (status == "0") {
                String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
                Pedido pedido;
                Cliente cliente = ClienteDAO.getInstance().getCliente(idCliente);
                pedido = new Pedido(0, null, timeStamp, cliente, null);
                PedidoDAO.getInstance().salvar(pedido);
                Pedido pedidoHolder = PedidoDAO.getInstance().getPedido(pedido.getId());
                Long idPedido = pedidoHolder.getId();
                request.getSession().setAttribute("idPedido", PedidoDAO.getInstance().getPedido(idPedido));
                request.getSession().setAttribute("status", "1");
            }
            
            request.setAttribute("idComida", this);
            request.setAttribute("operacao", operacao);
            Long idComida = Long.parseLong(request.getParameter("idComida"));

            if (!operacao.equals("Incluir")) {
                request.setAttribute("idComida", idComida);
                Long idComidaPedida;
                idComidaPedida = Long.parseLong(request.getParameter("idComidaPedida"));
                ComidaPedida comidaPedida = ComidaPedidaDAO.getInstance().getComidaPedida(idComidaPedida);
                request.setAttribute("comidaPedida", comidaPedida);
            }
            RequestDispatcher view = request.getRequestDispatcher("/ManterComidaPedida.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ManterComidaPedidaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManterComidaPedidaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operacao = request.getParameter("operacao");
        Long idComidaPedida = Long.parseLong(request.getParameter("txtIdComidaPedida"));
        Integer quantidade = Integer.parseInt(request.getParameter("txtQuantidade"));
        //Double total = Double.parseDouble(request.getParameter("txtTotal"));
        Long codComida = Long.parseLong(request.getParameter("optComida"));
        Long codPedido = Long.parseLong(request.getParameter("optPedido"));

        try {
            if (operacao.equals("Incluir")) {
                Comida comidaHolder = null;
                Long idComida;
                idComida = (Long) request.getAttribute("idComida");
                comidaHolder = ComidaDAO.getInstance().getComida(idComida);
                Double total = comidaHolder.getPreco() * quantidade;
                ComidaPedida comidaPedida = new ComidaPedida(quantidade, total, codComida, codPedido);
                ComidaPedidaDAO.getInstance().salvar(comidaPedida);
            }/* else {
                if (operacao.equals("Editar")) {
                    idComidaPedida = Long.parseLong(request.getParameter("txtIdComidaPedida"));
                    ComidaPedida comidaPedidaHolder = ComidaPedida.obterComidaPedida(idComidaPedida);
                    ComidaPedida comidaPedida = new ComidaPedida(idComidaPedida, quantidade, comidaPedidaHolder.getTotal(), codComida, codPedido);
                    comidaPedida.alterar();
                } */else {
                    if (operacao.equals("Excluir")) {
                        idComidaPedida = Long.parseLong(request.getParameter("txtIdComidaPedida"));

                        //ComidaPedida comidaPedidaHolder = ComidaPedida.obterComidaPedida(idComidaPedida);
                        ComidaPedida comidaPedida = ComidaPedidaDAO.getInstance().getComidaPedida(idComidaPedida) ;
                        ComidaPedidaDAO.getInstance().excluir(comidaPedida);
                    }
                }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaComidaPedidaController");
            view.forward(request, response);
            }catch (IOException e) {
            throw new ServletException(e);
        }catch(ServletException e){
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
            
