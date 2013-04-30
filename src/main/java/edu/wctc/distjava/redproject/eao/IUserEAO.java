package edu.wctc.distjava.redproject.eao;

import edu.wctc.distjava.redproject.model.Users;
import java.util.List;

/**
 *
 * @author Scott Odya
 */
public interface IUserEAO {
    
    Users getUserById(Object id);

    void create(Users user);

    //void deleteById(Long id);

    //public void deleteUser(User user);  //don't do.  Control user with user status.

    void update(Users user);

    Users findUser(Long id);

    List<Users> findUserEntities();

    List<Users> findUserEntities(int maxResults, int firstResult);

    int getUserCount();
    
    List<Users> findUserEntitiesByStatus();
    
    Users findUserByUserName (String name);

}
