
package TesteSobra;

import dao.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.CupomDesconto;


/**
 *
 * @author Yukas
 */
public class CupomDescontoDAO {
    
    private static CupomDescontoDAO instance = new CupomDescontoDAO();
    
    public static CupomDescontoDAO getInstance(){
        return instance;
    }
    
    private CupomDescontoDAO(){
        
    }
    
    public void salvar(CupomDesconto cupomDesconto){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            if(cupomDesconto.getId() != null){
                em.merge(cupomDesconto);
            }else{
                em.persist(cupomDesconto);
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
    
     public void excluir(CupomDesconto cupomDesconto){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.getReference(CupomDesconto.class, cupomDesconto.getId()));
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
     
       public CupomDesconto getCupomDesconto(long id){
        
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        CupomDesconto cupomDesconto = null;
        try{
            tx.begin();
            cupomDesconto = em.find(CupomDesconto.class, id);
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return cupomDesconto;
    }
       
        
    public List<CupomDesconto> getAllCupomDescontos(){
         
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<CupomDesconto> cupomDescontos = null;
        try{
            tx.begin();
            TypedQuery<CupomDesconto> query = em.createQuery("select cd from CupomDesconto cd", CupomDesconto.class);
            cupomDescontos = query.getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return cupomDescontos;
    }
    
    
}
