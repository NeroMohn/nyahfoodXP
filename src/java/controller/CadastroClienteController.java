package controller;

import dao.GeralDAO;
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

@WebServlet(name = "CadastroClienteController", urlPatterns = "/CadastroClienteController")
public class CadastroClienteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
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
            if (!operacao.equals("Incluir")) {
                Long idCliente = Long.parseLong(request.getParameter("id"));
                Cliente cliente = (Cliente) GeralDAO.getInstance().getObjeto(idCliente, Class.forName("model.Cliente"));
                request.setAttribute("cliente", cliente);
            }
            RequestDispatcher view = request.getRequestDispatcher("/CadastroCliente.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String operacao = request.getParameter("operacao");
        String nome = request.getParameter("txtNomeCliente");
        String cpf = request.getParameter("txtCpfCliente");
        String email = request.getParameter("txtEmailCliente");
        String senha = request.getParameter("txtSenhaCliente");
        String telefone = request.getParameter("txtTelefoneCliente");
        String cep = request.getParameter("txtCepCliente");
        String logradouro = request.getParameter("txtLogradouroCliente");
        String numero = request.getParameter("txtBairroCliente");
        String bairro = request.getParameter("txtNumeroCliente");
        String complemento = request.getParameter("txtComplementoCliente");
        String cidade = request.getParameter("txtCidadeCliente");
        String estado = request.getParameter("txtEstadoCliente");
        Long id = null;

        if (!operacao.equals("Incluir")) {
            id = Long.parseLong(request.getParameter("txtIdCliente"));
        }

        try {
            Cliente cliente = new Cliente(nome, cpf, email, senha, telefone, cep, logradouro, numero, bairro,
                    complemento, cidade, estado);

            Object objeto = cliente;

            if (operacao.equals("Incluir")) {
                GeralDAO.getInstance().salvar(objeto);
            } else if (operacao.equals("Editar")) {
                cliente.setId(id);
                GeralDAO.getInstance().salvar(objeto);
            } else if (operacao.equals("Excluir")) {
                cliente.setId(id);
                GeralDAO.getInstance().excluir(objeto);
            }
            RequestDispatcher view = request.getRequestDispatcher("LoginCliente.jsp");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
