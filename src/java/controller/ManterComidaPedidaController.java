/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GeralDAO;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
            throws ServletException, IOException, ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IllegalAccessException, InvocationTargetException {

        String tipo = request.getSession().getAttribute("tipo").toString();
        String acao = request.getParameter("acao");
        if (tipo != "1") {
            RequestDispatcher view = request.getRequestDispatcher("AcessoNegadoController");
            view.forward(request, response);
        } else {

            if (acao.equals("confirmarOperacao")) {
                try {
                    confirmarOperacao(request, response);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ManterComidaPedidaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (acao.equals("prepararOperacao")) {
                    prepararOperacao(request, response);

                }
            }
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException {
        try {

            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("comidas", GeralDAO.getInstance().getAllObjetos(Class.forName("model.Comida")));
            request.setAttribute("pedidos", GeralDAO.getInstance().getAllObjetos(Class.forName("model.Pedido")));
            request.setAttribute("pagamentos", GeralDAO.getInstance().getAllObjetos(Class.forName("model.TipoPagamento")));
            String tipo = request.getSession().getAttribute("tipo").toString();
            request.setAttribute("tipo", tipo);
            Long id = Long.parseLong(request.getParameter("id"));
            request.setAttribute("id", id);
            request.setAttribute("comida", (Comida) GeralDAO.getInstance().getObjeto(id, Class.forName("model.Comida")));

            if (!operacao.equals("Incluir")) {
                request.setAttribute("id", id);
                Long idComidaPedida;
                idComidaPedida = Long.parseLong(request.getParameter("id"));
                ComidaPedida comidaPedida = (ComidaPedida) GeralDAO.getInstance().getObjeto(idComidaPedida, Class.forName("model.ComidaPedida"));
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

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        String operacao = request.getParameter("operacao");
        String quantidade = request.getParameter("txtQuantidade");
        String tipoPagamento = request.getParameter("optPagamento");

        Long idCliente = Long.parseLong(request.getSession().getAttribute("id").toString());
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
        Cliente cliente = (Cliente) GeralDAO.getInstance().getObjeto(idCliente, Class.forName("model.Cliente"));
        Long id = Long.parseLong(request.getParameter("txtIdComidaPedida"));
        Comida comidaHolder = (Comida) GeralDAO.getInstance().getObjeto(id, Class.forName("model.Comida"));
        Double total = comidaHolder.getPreco() * Integer.parseInt(quantidade);
        Pedido pedido = new Pedido(total, tipoPagamento, timeStamp, cliente);
        Object objeto1 = pedido;
        GeralDAO.getInstance().salvar(objeto1);
  
       
        try {
            ComidaPedida comidaPedida = new ComidaPedida(Integer.parseInt(quantidade), total, comidaHolder, pedido, "Fazendo");

            Object objeto2 = comidaPedida;

            if (operacao.equals("Incluir")) {
                GeralDAO.getInstance().salvar(objeto2);
            } else if (operacao.equals("Editar")) {
                comidaPedida.setId(id);
                GeralDAO.getInstance().salvar(objeto2);
            } else if (operacao.equals("Excluir")) {
                comidaPedida.setId(id);
                GeralDAO.getInstance().excluir(objeto2);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPedidoClienteController");
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
            try {
                processRequest(request, response);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(ManterComidaPedidaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ManterComidaPedidaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(ManterComidaPedidaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterComidaPedidaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ManterComidaPedidaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(ManterComidaPedidaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ManterComidaPedidaController.class.getName()).log(Level.SEVERE, null, ex);
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
            try {
                processRequest(request, response);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(ManterComidaPedidaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ManterComidaPedidaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(ManterComidaPedidaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterComidaPedidaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ManterComidaPedidaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(ManterComidaPedidaController.class.getName()).log(Level.SEVERE, null, ex);
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
