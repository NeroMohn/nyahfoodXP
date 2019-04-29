package teste;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
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
    Cliente c1 = new Cliente("Lucas","10677662602","32153215","yukas@gmail.com","123123","36015370","Rua Barão","Santa Helena","aaa","juiz de Fora","MG","164");
    ClienteDAO.getInstance().salvar(c1);
    TipoCozinha tp1 = new TipoCozinha("Japonesa");
    TipoCozinhaDAO.getInstance().salvar(tp1);
    TipoPagamento p1 = new TipoPagamento("Dinheiro");
    TipoPagamentoDAO.getInstance().salvar(p1);
    Loja l1 = new Loja("NomeLoja","NomeGerente","3232323232","aaaaa@hotmail.com","123123","10099988823","Lugar legal",tp1,"foto",p1,"36011400","Rua Barão","Santa Helena","aaa","juiz de Fora","MG","164");
    LojaDAO.getInstance().salvar(l1);
         Adm adm = new Adm("admin","administrador","123456789" );
         AdmDAO.getInstance().salvar(adm);
}
}
