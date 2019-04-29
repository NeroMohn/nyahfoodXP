package model;

import dao.ComidaPedidaDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 *
 * @author Yukas
 */
@Entity
public class ComidaPedida implements Serializable{
    private static final long serialVerionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantidade;
    private double total;
    @ManyToOne
    private Comida comida;
    @ManyToOne
    private Pedido pedido;
    
    public ComidaPedida(){}

    
    public ComidaPedida(int quantidade, double total, Long codComida, Long codPedido) {
       
        setQuantidade(quantidade);
        setTotal(total);
        setComida(comida);
        setPedido(pedido);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public void salvar(){
        ComidaPedidaDAO.getInstance().salvar(this);
    }
    
    public void excluir(){
        ComidaPedidaDAO.getInstance().excluir(this);
    }
    
    public static ComidaPedida getComidaPedida(Long id){
        return ComidaPedidaDAO.getInstance().getComidaPedida(id);
    }
    
    public static List<ComidaPedida> getAllComidaPedidas(){
        return ComidaPedidaDAO.getInstance().getAllComidaPedidas();
    }
    
}
