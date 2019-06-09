package model;

import TesteSobra.CupomDescontoDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author Yukas
 */
@Entity
public class CupomDesconto implements Serializable{
    private static final long serialVerionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private double valor;
    private int ativo;
    
    public CupomDesconto(){
        
    }
    
    public CupomDesconto ( String nome, double valor, int ativo){
        this.nome = nome;
        this.valor = valor;
        this.ativo = ativo;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
    
        public void salvar(){
        CupomDescontoDAO.getInstance().salvar(this);
    }
    
    public void excluir(){
        CupomDescontoDAO.getInstance().excluir(this);
    }
    



}
