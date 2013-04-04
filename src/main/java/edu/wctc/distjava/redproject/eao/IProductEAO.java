package edu.wctc.distjava.redproject.eao;

import edu.wctc.distjava.redproject.model.Product;
import java.util.List;

/**
 *
 * @author Scott Odya
 */
public interface IProductEAO {
    
    Product getProductById(Object id);
    
    List<Product> getProductsByCategoryId(Integer id);

    void create(Product product);

    void deleteById(Long id);

    public void deleteProduct(Product product);

    void update(Product product);

    Product findProduct(Long id);

    List<Product> findProductEntities();

    List<Product> findProductEntities(int maxResults, int firstResult);

    int getProductCount();

}
