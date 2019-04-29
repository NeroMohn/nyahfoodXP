package model;

import java.io.Serializable;
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
public class TipoPagamento implements Serializable{
    private static final long serialVerionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    public TipoPagamento(){
        
    }
    
    public TipoPagamento(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
     public void salvar(){
        TipoPagamentoDAO.getInstance().salvar(this);
    }
    
    public void excluir(){
        TipoPagamentoDAO.getInstance().excluir(this);
    }
    
    public static TipoPagamento getTipoPagamento(Long id){
        return TipoPagamentoDAO.getInstance().getTipoPagamento(id);
    }
    
    public static List<TipoPagamento> getAllTipoPagamentos(){
        return TipoPagamentoDAO.getInstance().getAllTipoPagamentos();
    }
    

}
