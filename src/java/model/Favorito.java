package model;

import TesteSobra.FavoritoDAO;
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
public class Favorito implements Serializable{
    private static final long serialVerionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Favorito cliente;
    @ManyToOne
    private Loja loja;
    
    public Favorito(){}

    public Favorito(Favorito cliente, Loja loja) {
        this.cliente = cliente;
        this.loja = loja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Favorito getFavorito() {
        return cliente;
    }

    public void setFavorito(Favorito cliente) {
        this.cliente = cliente;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
    
     public void salvar(){
        FavoritoDAO.getInstance().salvar(this);
    }
    
    public void excluir(){
        FavoritoDAO.getInstance().excluir(this);
    }
    

    
    
}
