package edu.wctc.distjava.redproject.eao;

import edu.wctc.distjava.redproject.model.Category;
import java.util.List;
import javax.persistence.Query;


/**
 *
 * @author Scott Odya
 */
public interface ICategoryEAO {
    
    public abstract List<Category> getAllCategories();
    
    public abstract String getCategoryById(Object id);
    
    public abstract List<Category> getAllCategoryIds();

}
