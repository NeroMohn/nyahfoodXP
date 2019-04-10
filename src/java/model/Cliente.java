package model;

import javax.persistence.Entity;


/**
 *
 * @author Yukas
 */
@Entity
public class Cliente extends Usuario {

    private String cpf;

    public Cliente() {

    }

    public Cliente(String nome,String cpf, String telefone, String email, String senha, String cep, String logradouro, String bairro, String complemento, String cidade, String estado, String numero) {
        super(nome, telefone, email, senha, cep, logradouro, bairro, complemento, cidade, estado, numero);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
