package model;

import TesteSobra.TipoCozinhaDAO;
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
public class TipoCozinha implements Serializable{
    private static final long serialVerionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    public TipoCozinha(){
        
    }
    public TipoCozinha(String nome) {
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
        TipoCozinhaDAO.getInstance().salvar(this);
    }
    
    public void excluir(){
        TipoCozinhaDAO.getInstance().excluir(this);
    }
    

    
    
    
}
