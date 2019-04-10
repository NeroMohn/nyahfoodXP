package teste;

import dao.ClienteDAO;
import model.Cliente;

/**
 *
 * @author Yukas
 */
public class ClienteTeste {
     public static void main(String[] args) {
    Cliente c1 = new Cliente("Lucas","10677662602","32153215","yukas@gmail.com","123123","36015370","Rua Barão","Santa Helena","aaa","juiz de Fora","MG","164");
    ClienteDAO.getInstance().salvar(c1);
}
}
