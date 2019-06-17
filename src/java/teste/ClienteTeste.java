package teste;



import dao.GeralDAO;
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
    GeralDAO.getInstance().salvar(tp1);
     TipoCozinha tp2 = new TipoCozinha("Inglesa");
    GeralDAO.getInstance().salvar(tp2);
    TipoPagamento p1 = new TipoPagamento("Dinheiro");
    GeralDAO.getInstance().salvar(p1);
    TipoPagamento p2 = new TipoPagamento("Cartao");
    GeralDAO.getInstance().salvar(p2);
    Adm a1 = new Adm("admin","Admin","123");
    GeralDAO.getInstance().salvar(a1);
}
}
