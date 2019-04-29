
package model;

import dao.AdmDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Adm implements Serializable {
private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String senha;
    private String login;
    
    public Adm(){
        
    }

    public Adm(String login,String nome, String senha){
       this.nome = nome;
       this.senha = senha;
       this.login = login;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
           public void salvar(){
        AdmDAO.getInstance().salvar(this);
    }
    
    public void excluir(){
        AdmDAO.getInstance().excluir(this);
    }
    
    public static Adm getAdm(long id){
        return AdmDAO.getInstance().getAdm(id);
    }
    
    public static List<Adm> getAllAdms(){
        return AdmDAO.getInstance().getAllAdms();
    }
}
