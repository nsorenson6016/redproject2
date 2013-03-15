package edu.wctc.distjava.redproject.model;

//import javax.ejb.Stateless;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author scottodya
 */
@Repository
//@Named
//@Stateless  (not anymore with Spring)
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)  //in place of using an interface.
//@Scope("session")  // for interfaces.
@Transactional(readOnly=true)

public class ProductEAO implements IProductEAO{
    @PersistenceContext
            //(unitName = "redproject2PU")
    private EntityManager em;
    
//@Transactional(readOnly=false, rollbackFor = Exception.class)  //for methods that do write operation

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public Product getProductById(Object id) {
        return getEm().find(Product.class, id);
    }
    /////////////////
    
    @Override
    public List<Product> productsByCategory(Object category) {
        //Query query = em.createQuery("select * from product where category_id = :category");
        //query.setParameter("category", category);
        
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Product.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }
    
    @Override
    public void create(Product product) {
        em.persist(product);
    }

    @Override
    public void update(Product product) {
        product = em.merge(product);
    }

    @Override
    public void deleteById(Long id) {
        Product product;
        product = em.getReference(Product.class, id);
        em.remove(product);
    }

    public void deleteBook(Product product) {
        em.remove(em.merge(product));
    }

    @Override
    public List<Product> findProductEntities() {
        return findProductEntities(true, -1, -1);
    }

    @Override
    public List<Product> findProductEntities(int maxResults, int firstResult) {
        return findProductEntities(false, maxResults, firstResult);
    }

    private List<Product> findProductEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Product.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    @Override
    public Product findProduct(Long id) {
        return em.find(Product.class, id);
    }

    @Override
    public int getProductCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Product> rt = cq.from(Product.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    @Override
    public void deleteProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
