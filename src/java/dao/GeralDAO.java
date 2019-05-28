
package dao;
import java.lang.reflect.Field;
import java.util.List;
import java.lang.reflect.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Cliente;



/**
 *
 * @author Yukas
 */
public class GeralDAO {
    
    private static GeralDAO instance = new GeralDAO();
    
    public static GeralDAO getInstance(){
        return instance;
    }
    
    private GeralDAO(){
        
    }
    
    public void salvar(Class classe){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
         
        try{
            tx.begin();
            
            Method m = classe.getMethod("getId", null);
                
            if( m != null){
                em.merge(classe);
            }else{
                em.persist(classe);
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
    
     public void excluir(Cliente cliente){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.getReference(Cliente.class, cliente.getId()));
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
     
       public Cliente getCliente(long id){
        
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Cliente cliente = null;
        try{
            tx.begin();
            cliente = em.find(Cliente.class, id);
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return cliente;
    }
       
        
    public List<Cliente> getAllClientes(){
         
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Cliente> clientes = null;
        try{
            tx.begin();
            TypedQuery<Cliente> query = em.createQuery("select cl from Cliente cl", Cliente.class);
            clientes = query.getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return clientes;
    }
    
    public Cliente getClienteEmail(String email){
        
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Cliente cliente = null;
        try{
            tx.begin();
            TypedQuery<Cliente> query = em.createQuery("select c From Cliente c where c.email LIKE :email", Cliente.class);
            query.setParameter("email", email);
            
            cliente = query.getSingleResult();
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
                return cliente;
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return cliente;
    }
    
    
}
