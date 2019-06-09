package model;

import TesteSobra.PedidoDAO;
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
public class Pedido implements Serializable{
    private static final long serialVerionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    private double total;
    private String metodoPagamento;
    private String date;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private CupomDesconto cupomDesconto;
    
    public Pedido(){
        
    }


    public Pedido(double total, String metodoPagamento, String date, Cliente cliente, CupomDesconto cupomDesconto) {
        this.total = total;
        this.metodoPagamento = metodoPagamento;
        this.date = date;
        this.cliente = cliente;
        this.cupomDesconto = cupomDesconto;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CupomDesconto getCupomDesconto() {
        return cupomDesconto;
    }

    public void setCupomDesconto(CupomDesconto cupomDesconto) {
        this.cupomDesconto = cupomDesconto;
    }
    
        public void salvar(){
        PedidoDAO.getInstance().salvar(this);
    }
    
    public void excluir(){
        PedidoDAO.getInstance().excluir(this);
    }
    


}
