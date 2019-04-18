package controller;

import dao.ClienteDAO;
import java.io.IOException;
import static java.lang.Long.parseLong;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.swing.text.html.CSS.getAttribute;
import model.Cliente;

@WebServlet(name = "CadastroClienteController", urlPatterns = "/CadastroClienteController")
public class CadastroClienteController extends HttpServlet {

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
                Long idCliente = Long.parseLong(request.getParameter("idCliente"));
                Cliente cliente = ClienteDAO.getInstance().getCliente(idCliente);
                request.setAttribute("cliente", cliente);
            }
            RequestDispatcher view = request.getRequestDispatcher("/CadastroCliente.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(CadastroClienteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadastroClienteController.class.getName()).log(Level.SEVERE, null, ex);
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
        String bairro = request.getParameter("txtBairroCliente");
        String numero = request.getParameter("txtNumeroCliente");
        String complemento = request.getParameter("txtComplementoCliente");
        String cidade = request.getParameter("txtCidadeCliente");
        String estado = request.getParameter("txtEstadoCliente");

        try {
            if (operacao.equals("Incluir")) {
                Cliente cliente = new Cliente(nome, cpf, email, senha, telefone, cep,logradouro, bairro, numero,
                        complemento, cidade, estado);
                ClienteDAO.getInstance().salvar(cliente);
            } else {
                if (operacao.equals("Editar")) {
                    Long idCliente = parseLong(request.getSession().getAttribute("id").toString());
                    Cliente cliente = new Cliente(nome, cpf, email, senha, telefone, logradouro, cep, numero, bairro,
                            complemento, cidade, estado);
                    ClienteDAO.getInstance().salvar(cliente);
                } else {
                    if (operacao.equals("Excluir")) {
                        Long idCliente = Long.parseLong(request.getParameter("txtIdCliente"));
                        Cliente cliente = new Cliente(nome, cpf, email, senha, telefone, logradouro, cep, numero, bairro,
                                complemento, cidade, estado);
                        ClienteDAO.getInstance().excluir(cliente);
                    }
                }
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
