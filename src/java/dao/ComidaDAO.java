
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Comida;
import model.Loja;


/**
 *
 * @author Yukas
 */
public class ComidaDAO {
    
    private static ComidaDAO instance = new ComidaDAO();
    
    public static ComidaDAO getInstance(){
        return instance;
    }
    
    private ComidaDAO(){
        
    }
    
    public void salvar(Comida comida){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            if(comida.getId() != null){
                em.merge(comida);
            }else{
                em.persist(comida);
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
    
     public void excluir(Comida comida){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.getReference(Comida.class, comida.getId()));
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
     
       public Comida getComida(long id){
        
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Comida comida = null;
        try{
            tx.begin();
            comida = em.find(Comida.class, id);
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return comida;
    }
       
        
    public List<Comida> getAllComidas(){
         
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Comida> comidas = null;
        try{
            tx.begin();
            TypedQuery<Comida> query = em.createQuery("select co from Comida co ", Comida.class);
            comidas = query.getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return comidas;
    }
    
        public List<Comida> getAllComidasFromLoja(Long id){
        
        Loja loja= LojaDAO.getInstance().getLoja(id);
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Comida> comidas = null;
        try{
            tx.begin();
            TypedQuery<Comida> query = em.createQuery("select co from Comida co where co.loja LIKE loja ", Comida.class);
            query.setParameter("loja", loja);
            comidas = query.getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return comidas;
    }
    
    
}
