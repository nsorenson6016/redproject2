package edu.wctc.distjava.redproject.eao;

import edu.wctc.distjava.redproject.model.Bid;
import java.util.List;

/**
 *
 * @author Scott Odya
 */
public interface IBidEAO {
    
    Bid getBidById(Object id);

    void create(Bid bid);

    //void deleteById(Long id);

    //public void deleteUser(User user);  //don't do.  Control user with user status.

    void update(Bid bid);

    Bid findBid(Long id);

    List<Bid> findBidEntities();

    List<Bid> findBidEntities(int maxResults, int firstResult);

    int getBidCount();
    
    List<Bid> findBidEntitiesByStatus();
    
    
    
    

}
