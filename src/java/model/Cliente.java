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
public class Cliente extends Usuario implements Serializable {

    private static final long serialVerionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cpf;

    public Cliente() {

    }

    public Cliente(String nome, String cpf,
            String email, String senha, String telefone,
            String logradouro, String cep, String numero,
            String bairro, String complemento, String cidade,
            String estado) {
        super(nome, email, senha, telefone, logradouro, cep, numero, bairro, complemento, cidade, estado);
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
