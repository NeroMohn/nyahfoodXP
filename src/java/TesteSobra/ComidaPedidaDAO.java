
package TesteSobra;

import dao.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.ComidaPedida;


/**
 *
 * @author Yukas
 */
public class ComidaPedidaDAO {
    
    private static ComidaPedidaDAO instance = new ComidaPedidaDAO();
    
    public static ComidaPedidaDAO getInstance(){
        return instance;
    }
    
    private ComidaPedidaDAO(){
        
    }
    
    public void salvar(ComidaPedida comidaPedida){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            if(comidaPedida.getId() != null){
                em.merge(comidaPedida);
            }else{
                em.persist(comidaPedida);
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
    
     public void excluir(ComidaPedida comidaPedida){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.getReference(ComidaPedida.class, comidaPedida.getId()));
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
     
       public ComidaPedida getComidaPedida(long id){
        
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        ComidaPedida comidaPedida = null;
        try{
            tx.begin();
            comidaPedida = em.find(ComidaPedida.class, id);
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return comidaPedida;
    }
       
        
    public List<ComidaPedida> getAllComidaPedidas(){
         
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<ComidaPedida> comidaPedidas = null;
        try{
            tx.begin();
            TypedQuery<ComidaPedida> query = em.createQuery("select cop from ComidaPedida cop", ComidaPedida.class);
            comidaPedidas = query.getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return comidaPedidas;
    }
    
    
}
