/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


/**
 *
 * @author Yukas
 */
@Entity
public class Loja extends Usuario {
    private String cnpj;
    private String descricao;
    private String nomeGerente;
    private String pagamento;
    private String foto;
    @ManyToOne
    private TipoCozinha tipoCozinha;

    
    public Loja(){
        
    }

    public Loja(String nome, String nomeGerente, String email, String senha, String telefone, String cnpj,String descricao,Long codTipoCozinha,String foto,String cep, String logradouro, String bairro,String numero, String complemento, String cidade, String estado) {
        super(nome, email, senha, telefone, logradouro, cep, numero, bairro, complemento, cidade, estado);
        this.nomeGerente = nomeGerente;
        this.foto = foto;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.tipoCozinha = tipoCozinha;
    }


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String CNPJ) {
        this.cnpj = CNPJ;
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

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
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
