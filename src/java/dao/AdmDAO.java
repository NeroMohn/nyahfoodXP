
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Adm;


/**
 *
 * @author Yukas
 */
public class AdmDAO {
    
    private static AdmDAO instance = new AdmDAO();
    
    public static AdmDAO getInstance(){
        return instance;
    }
    
    private AdmDAO(){
        
    }
    
    public void salvar(Adm adm){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            if(adm.getId() != null){
                em.merge(adm);
            }else{
                em.persist(adm);
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
    
     public void excluir(Adm adm){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.getReference(Adm.class, adm.getId()));
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
     
       public Adm getAdm(long id){
        
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Adm adm = null;
        try{
            tx.begin();
            adm = em.find(Adm.class, id);
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return adm;
    }
       
        
    public List<Adm> getAllAdms(){
         
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Adm> adms = null;
        try{
            tx.begin();
            TypedQuery<Adm> query = em.createQuery("select a from Adm a", Adm.class);
            adms = query.getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return adms;
    }
    
    public Adm getAdm(String login){
        
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
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return adm;
    }
    
}
