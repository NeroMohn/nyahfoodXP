
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Pedido;


/**
 *
 * @author Yukas
 */
public class PedidoDAO {
    
    private static PedidoDAO instance = new PedidoDAO();
    
    public static PedidoDAO getInstance(){
        return instance;
    }
    
    private PedidoDAO(){
        
    }
    
    public void salvar(Pedido pedido){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            if(pedido.getId() != null){
                em.merge(pedido);
            }else{
                em.persist(pedido);
            }
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
    }
    
     public void excluir(Pedido pedido){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.getReference(Pedido.class, pedido.getId()));
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
    }
     
       public Pedido getPedido(long id){
        
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Pedido pedido = null;
        try{
            tx.begin();
            pedido = em.find(Pedido.class, id);
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return pedido;
    }
       
        
    public List<Pedido> getAllPedidos(){
         
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Pedido> pedidos = null;
        try{
            tx.begin();
            TypedQuery<Pedido> query = em.createQuery("select pe from Pedido pe", Pedido.class);
            pedidos = query.getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return pedidos;
    }
    
    
}
