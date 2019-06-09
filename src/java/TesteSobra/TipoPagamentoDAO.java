
package TesteSobra;

import dao.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.TipoPagamento;


/**
 *
 * @author Yukas
 */
public class TipoPagamentoDAO {
    
    private static TipoPagamentoDAO instance = new TipoPagamentoDAO();
    
    public static TipoPagamentoDAO getInstance(){
        return instance;
    }
    
    private TipoPagamentoDAO(){
        
    }
    
    public void salvar(TipoPagamento tipoPagamento){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            if(tipoPagamento.getId() != null){
                em.merge(tipoPagamento);
            }else{
                em.persist(tipoPagamento);
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
    
     public void excluir(TipoPagamento tipoPagamento){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.getReference(TipoPagamento.class, tipoPagamento.getId()));
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
     
       public TipoPagamento getTipoPagamento(long id){
        
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        TipoPagamento tipoPagamento = null;
        try{
            tx.begin();
            tipoPagamento = em.find(TipoPagamento.class, id);
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return tipoPagamento;
    }
       
        
    public List<TipoPagamento> getAllTipoPagamentos(){
         
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<TipoPagamento> tipoPagamentos = null;
        try{
            tx.begin();
            TypedQuery<TipoPagamento> query = em.createQuery("select tp from TipoPagamento tp", TipoPagamento.class);
            tipoPagamentos = query.getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return tipoPagamentos;
    }
    
    
}
