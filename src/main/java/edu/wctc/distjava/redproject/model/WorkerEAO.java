package edu.wctc.distjava.redproject.model;

//import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

public class WorkerEAO {
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
    
    public Worker getWorkerById(Object id) {
        return getEm().find(Worker.class, id);
    }
}
