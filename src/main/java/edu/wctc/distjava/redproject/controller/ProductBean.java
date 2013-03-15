package edu.wctc.distjava.redproject.controller;

import edu.wctc.distjava.redproject.model.IProductEAO;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author scottodya
 */
@Named
@Scope
public class ProductBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Inject
    private IProductEAO eao;
    
    /**
     * Creates a new instance of ProductBean
     */
    public ProductBean() {
    }
}
