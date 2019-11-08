package model;


import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
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
    private String promocao;
    
   
    
    public String promocaoSemana(){
         
         String dayOfWeek = LocalDate.now().getDayOfWeek().name();
        if(dayOfWeek == "Sunday"){
            promocao = "frios";
        }
         else if(dayOfWeek == "Monday"){
            promocao = "quentes";
        }
                 else if(dayOfWeek == "Tuesday"){
            promocao = "churrasco";
        }
                  else if(dayOfWeek == "Wednesday"){
            promocao = "bebidas";
        }
                  else if(dayOfWeek == "Thursday"){
            promocao = "massa";
        }
                   else if(dayOfWeek == "Friday"){
            promocao = "molho";
        }
                    else if(dayOfWeek == "Saturday"){
            promocao = "chines";
        }
       
                          
            return promocao;
        
    }

    
    
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
    

    
    
    
}
