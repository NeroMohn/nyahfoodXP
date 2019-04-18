/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Loja extends Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cnpj;
    private String descricao;
    private String nomeGerente;
    @ManyToOne
    private TipoPagamento tipoPagamento;
    private String foto;
    @ManyToOne
    private TipoCozinha tipoCozinha;

    
    public Loja(){
        
    }
    public Loja(String nome, String nomeGerente, String telefone, String email,
            String senha, String cnpj,String descricao,TipoCozinha tipoCozinha,
            String foto,TipoPagamento tipoPagamento, String cep, String logradouro,
            String bairro,String complemento, String cidade, String estado,
            String numero) {
        super(nome, telefone, email, senha, cep, logradouro, bairro, complemento, cidade, estado, numero);
        this.nomeGerente = nomeGerente;
        this.foto = foto;
        this.tipoPagamento = tipoPagamento;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.tipoCozinha = tipoCozinha;
    }    
        public Loja(String nome, String nomeGerente, String telefone, String email,
            String senha, String cnpj,String descricao,TipoCozinha tipoCozinha,
            String foto,String cep, String logradouro,
            String bairro,String complemento, String cidade, String estado,
            String numero) {
        super(nome, telefone, email, senha, cep, logradouro, bairro, complemento, cidade, estado, numero);
        this.nomeGerente = nomeGerente;
        this.foto = foto;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.tipoCozinha = tipoCozinha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeGerente() {
        return nomeGerente;
    }

    public void setNomeGerente(String nomeGerente) {
        this.nomeGerente = nomeGerente;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public TipoCozinha getTipoCozinha() {
        return tipoCozinha;
    }

    public void setTipoCozinha(TipoCozinha tipoCozinha) {
        this.tipoCozinha = tipoCozinha;
    }


}
