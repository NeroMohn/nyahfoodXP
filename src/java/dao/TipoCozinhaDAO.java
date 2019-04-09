
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.TipoCozinha;


/**
 *
 * @author Yukas
 */
public class TipoCozinhaDAO {
    
    private static TipoCozinhaDAO instance = new TipoCozinhaDAO();
    
    public static TipoCozinhaDAO getInstance(){
        return instance;
    }
    
    private TipoCozinhaDAO(){
        
    }
    
    public void salvar(TipoCozinha tipoCozinha){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            if(tipoCozinha.getId() != null){
                em.merge(tipoCozinha);
            }else{
                em.persist(tipoCozinha);
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
    
     public void excluir(TipoCozinha tipoCozinha){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.getReference(TipoCozinha.class, tipoCozinha.getId()));
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
     
       public TipoCozinha getTipoCozinha(long id){
        
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        TipoCozinha tipoCozinha = null;
        try{
            tx.begin();
            tipoCozinha = em.find(TipoCozinha.class, id);
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return tipoCozinha;
    }
       
        
    public List<TipoCozinha> getAllTipoCozinhas(){
         
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<TipoCozinha> tipoCozinhas = null;
        try{
            tx.begin();
            TypedQuery<TipoCozinha> query = em.createQuery("select tc from TipoCozinha tc", TipoCozinha.class);
            tipoCozinhas = query.getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return tipoCozinhas;
    }
    
    
}
