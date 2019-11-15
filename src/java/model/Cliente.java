package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;


/**
 *
 * @author Yukas
 */
@Entity
public class Cliente extends Usuario implements Serializable {
    
    private String cpf;
    
    private int idade;
    public float desconto;
    public String sex;
    
    public float distancia;
    
    public Cliente() {

    }
    
    public Cliente(String nome,String cpf, String email, String senha, String telefone, String cep, String logradouro, String bairro,String numero, String complemento, String cidade, String estado) {
        super(nome, email, senha, telefone, cep, logradouro, bairro, numero, complemento, cidade, estado);
        this.cpf = cpf;
    }
    
        public Cliente(Long id){
        super(id);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }
    
    
    
    public float promocao(){
       
        if(sex == "M"){
            if(idade < 10){
            desconto = 0.3f;
        }else if(idade < 15){
            desconto = 0.20f;
        }else if (idade  < 20){
            desconto = 0.1f;
        }else if (idade < 30){
            desconto = 0.05f;
        }else{
           desconto = 0.5f;
        } 
        }else{
         if(idade < 10){
            desconto = 0.4f;
        }else if(idade < 15){
            desconto = 0.30f;
        }else if (idade  < 20){
            desconto = 0.2f;
        }else if (idade < 30){
            desconto = 0.1f;
        }else{
           desconto = 0.6f;
        } 
        }
        return desconto;
    }
    
    
    
    

   
    
}
