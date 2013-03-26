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

public class BidEAO implements IBidEAO{
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
    public Bid getBidById(Object id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Bid bid) {
        em.persist(bid);
    }

    @Override
    public void update(Bid bid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Bid findBid(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Bid> findBidEntities() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Bid> findBidEntities(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getBidCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Bid> findBidEntitiesByStatus() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

  
    
    
}
