package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author Yukas
 */
@Entity
public class Cliente extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cpf;

    public Cliente() {

    }

    public Cliente(String nome,String cpf, String telefone, String email, String senha, String cep, String logradouro, String bairro, String complemento, String cidade, String estado, String numero) {
        super(nome, telefone, email, senha, cep, logradouro, bairro, complemento, cidade, estado, numero);
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



}
