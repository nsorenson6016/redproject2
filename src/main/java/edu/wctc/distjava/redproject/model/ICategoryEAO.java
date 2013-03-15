package edu.wctc.distjava.redproject.model;

import java.util.List;
import javax.persistence.Query;


/**
 *
 * @author Scott Odya
 */
public interface ICategoryEAO {
    
    public abstract List<Category> getAllCategories();
    
    public abstract String getCategoryById(Object id);

}
