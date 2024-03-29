package edu.wctc.distjava.redproject.eao;

//import javax.ejb.Stateless;
import edu.wctc.distjava.redproject.model.Category;
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

public class CategoryEAO implements ICategoryEAO{
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
    public List<Category> getAllCategories() {
        List orders = em.createNamedQuery("Category.findAll").getResultList();
        return orders;
    }
   
    @Override
    public String getCategoryById(Object id) {
        String category = (String) em.createNamedQuery("Category.findByCategoryId").setParameter("categoryId", id).getSingleResult();
        return category;
    }

    @Override
    public List<Category> getAllCategoryIds() {
        List categories = em.createNamedQuery("Category.findAllCategoryIds").getResultList();
        return categories;
    }
    
    
}
