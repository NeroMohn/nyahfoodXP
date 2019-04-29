package model;

import dao.ComidaDAO;
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
public class Comida implements Serializable {

    private static final long serialVerionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String ingrediente;
    private int tempoEstimado;
    private String foto;
    private double preco;
    private double desconto;
    @ManyToOne
    private Loja loja;

    public Comida() {

    }

    public Comida(String nome, String ingrediente, int tempoEstimado, String foto, double preco,
            Long codLoja) {

        setNome(nome);
        setIngrediente(ingrediente);
        setTempoEstimado(tempoEstimado);
        setFoto(foto);
        setPreco(preco);
        setLoja(loja);

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public int getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(int tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

 public void salvar(){
        ComidaDAO.getInstance().salvar(this);
    }
    
    public void excluir(){
        ComidaDAO.getInstance().excluir(this);
    }
    
    public static Comida getCliente(long id){
        return ComidaDAO.getInstance().getComida(id);
    }
    
    public static List<Comida> getAllClientes(){
        return ComidaDAO.getInstance().getAllComidas();
    }

}
