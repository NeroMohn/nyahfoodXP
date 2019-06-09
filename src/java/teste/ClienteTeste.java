package teste;

import TesteSobra.AdmDAO;
import TesteSobra.ClienteDAO;
import TesteSobra.LojaDAO;
import TesteSobra.TipoCozinhaDAO;
import TesteSobra.TipoPagamentoDAO;
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
     TipoCozinha tp2 = new TipoCozinha("Inglesa");
    TipoCozinhaDAO.getInstance().salvar(tp2);
    TipoPagamento p1 = new TipoPagamento("Dinheiro");
    TipoPagamentoDAO.getInstance().salvar(p1);
    TipoPagamento p2 = new TipoPagamento("Cartao");
    TipoPagamentoDAO.getInstance().salvar(p2);
    Adm a1 = new Adm("admin","Admin","123");
    AdmDAO.getInstance().salvar(a1);
}
}
