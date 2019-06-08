
package dao;
import java.lang.reflect.Field;
import java.util.List;
import java.lang.reflect.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Adm;
import model.Cliente;
import model.Loja;




public class GeralDAO {
    
    private static GeralDAO instance = new GeralDAO();
    
    public static GeralDAO getInstance(){
        return instance;
    }
    
    private GeralDAO(){
        
    }
    
    public void salvar(Object objeto){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
         
        try{
            tx.begin();
            Method metodo = objeto.getClass().getMethod("getId", null);
            //Class c = objeto.getClass();
            if( metodo != null){
                em.merge(objeto);
            }else{
                em.persist(objeto);
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
    
     public void excluir(Object objeto){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            Method metodo = objeto.getClass().getMethod("getId", null);
            em.remove(em.getReference(objeto.getClass(), metodo.invoke(objeto)));
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
     
       public Object getObjeto(long id, Class classe){
        
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
      
        Object obj = null;
        try{
            tx.begin();
            
            obj = em.find(classe, id);
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return obj;
    }
       
        
    public List<Object> getAllObjetos(Class classe){
         
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Object> objects = null;
        try{
            tx.begin();
            TypedQuery<Object> query = em.createQuery("select cl from "+ classe.getName() +" cl", classe);
            objects = query.getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return objects;
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
    public Loja getLojaEmail(String email){
        
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Loja loja = null;
        try{
            tx.begin();
            TypedQuery<Loja> query = em.createQuery("select l From Loja l where l.email LIKE :email", Loja.class);
            query.setParameter("email", email);
            
            loja = query.getSingleResult();
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                
                tx.rollback();
                return loja;
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return loja;
    }
    
    
    public Adm getAdmLogin(String login){
        
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Adm adm = null;
        try{
           tx.begin();
            TypedQuery<Adm> query = em.createQuery("select a From Adm a where a.login LIKE :login", Adm.class);
            query.setParameter("login", login);
            
            adm = query.getSingleResult();
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
                return adm;
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return adm;
    }
    
    
}
