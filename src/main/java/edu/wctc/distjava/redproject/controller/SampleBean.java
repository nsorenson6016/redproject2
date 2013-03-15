package edu.wctc.distjava.redproject.controller;

import edu.wctc.distjava.redproject.model.Product;
import edu.wctc.distjava.redproject.model.ProductEAO;
import edu.wctc.distjava.redproject.model.Worker;
import edu.wctc.distjava.redproject.model.WorkerEAO;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 * A sample JSF Managed Bean
 * @author  jlombardo
 * @version 1.00
 */
//@ManagedBean(name = "sample")
@Named
//@ViewScoped
@Scope("session")
public class SampleBean implements Serializable {
    // Incremement this with each structural class change
    private static final long serialVersionUID = 1L;
    
    private String message = "Hello From JSF Managed Bean";

    @Inject
    private ProductEAO eao;
    
    /**
     * Creates a new instance of SampleBean
     */
    public SampleBean() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public Product getProductById(String id){
        return eao.getProductById(new Integer(id));
    }
    
    
}
