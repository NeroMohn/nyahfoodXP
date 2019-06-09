
package TesteSobra;

import dao.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Favorito;


/**
 *
 * @author Yukas
 */
public class FavoritoDAO {
    
    private static FavoritoDAO instance = new FavoritoDAO();
    
    public static FavoritoDAO getInstance(){
        return instance;
    }
    
    private FavoritoDAO(){
        
    }
    
    public void salvar(Favorito favorito){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            if(favorito.getId() != null){
                em.merge(favorito);
            }else{
                em.persist(favorito);
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
    
     public void excluir(Favorito favorito){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.getReference(Favorito.class, favorito.getId()));
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
     
       public Favorito getFavorito(long id){
        
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Favorito favorito = null;
        try{
            tx.begin();
            favorito = em.find(Favorito.class, id);
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return favorito;
    }
       
        
    public List<Favorito> getAllFavoritos(){
         
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Favorito> favoritos = null;
        try{
            tx.begin();
            TypedQuery<Favorito> query = em.createQuery("select fa from Favorito fa", Favorito.class);
            favoritos = query.getResultList();
            tx.commit();
        } catch (Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            PersistenceUtil.close(em);
        }
        return favoritos;
    }
    
    
}
