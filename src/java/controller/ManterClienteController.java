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
import model.Cliente;
import dao.ClienteDAO;

/**
 *
 * @author David
 */

@WebServlet (name= "ManterClienteController", urlPatterns = "/ManterClienteController")
public class ManterClienteController extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) {
        try{
        String operacao = request.getParameter("operacao");
        request.setAttribute("operacao", operacao);
        if (!operacao.equals("Incluir")) {
            Long idCliente = Long.parseLong(request.getParameter("idCliente"));
            Cliente cliente = ClienteDAO.getInstance().getCliente(idCliente);
            request.setAttribute("cliente", cliente);
        }
        RequestDispatcher view = request.getRequestDispatcher("/ManterCliente.jsp");    
        view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
}

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        String operacao = request.getParameter("operacao");
        String nome = request.getParameter("txtNomeCliente");
        String cpf = request.getParameter("txtCpfCliente");
        String email =  request.getParameter("txtEmailCliente");
        String senha =  request.getParameter("txtSenhaCliente");
        String telefone =  request.getParameter("txtTelefoneCliente");
        String logradouro =  request.getParameter("txtLogradouroCliente");
        String cep =  request.getParameter("txtCepCliente");
        String numero =  request.getParameter("txtNumeroCliente");
        String bairro =  request.getParameter("txtBairroCliente");
        String complemento =  request.getParameter("txtComplementoCliente");
        String cidade =  request.getParameter("txtCidadeCliente");
        String estado =  request.getParameter("txtEstadoCliente");
       
        try {
        if (operacao.equals("Incluir")){
            Cliente cliente = new Cliente( nome, cpf, email, senha, telefone, logradouro, cep, numero, bairro,
                complemento, cidade, estado);
            ClienteDAO.getInstance().salvar(cliente);
        //}else{ 
            /*if(operacao.equals("Editar")){
               //  com isso editar nao funciona Long idCliente =parseLong(request.getSession().getAttribute("id").toString());
                Long idCliente = Long.parseLong(request.getParameter("txtIdCliente"));
                Cliente cliente;
                cliente = new Cliente(idCliente, nome, cpf, email, senha, telefone, logradouro, cep, numero, bairro,
                        complemento, cidade, estado);
                cliente.alterar();*/
        } else{ 
                if (operacao.equals("Excluir")){
                Long idCliente = Long.parseLong(request.getParameter("txtIdCliente"));
                Cliente cliente = ClienteDAO.getInstance().getCliente(idCliente);
                ClienteDAO.getInstance().excluir(cliente);
                }
            }
        RequestDispatcher view =request.getRequestDispatcher("PesquisaClienteControllerADM");
        view.forward(request,response);
        }catch (IOException e) {
            throw new ServletException(e);
            
        }catch(ServletException e){
            
            throw e;
        }
    }
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

        @Override
        public String getServletInfo() {
        return "Short description";
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
