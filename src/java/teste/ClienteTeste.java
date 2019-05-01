package teste;

import dao.AdmDAO;
import dao.ClienteDAO;
import dao.LojaDAO;
import dao.TipoCozinhaDAO;
import dao.TipoPagamentoDAO;
import model.Adm;
import model.Cliente;
import model.Loja;
import model.TipoCozinha;
import model.TipoPagamento;

/**
 *
 * @author Yukas
 */
public class ClienteTeste {
     public static void main(String[] args) {
    TipoCozinha tp1 = new TipoCozinha("Japonesa");
    TipoCozinhaDAO.getInstance().salvar(tp1);
    TipoPagamento p1 = new TipoPagamento("Dinheiro");
    TipoPagamentoDAO.getInstance().salvar(p1);
    Adm a1 = new Adm("admin","Admin","123");
    AdmDAO.getInstance().salvar(a1);
}
}
