package edu.wctc.distjava.redproject.controller;

import edu.wctc.distjava.redproject.model.Category;
import edu.wctc.distjava.redproject.eao.ICategoryEAO;
import edu.wctc.distjava.redproject.model.Product;
import edu.wctc.distjava.redproject.eao.IProductEAO;
import edu.wctc.distjava.redproject.model.Worker;
import edu.wctc.distjava.redproject.eao.WorkerEAO;
import java.io.Serializable;
import java.util.List;
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
public class CategoryBean implements Serializable {
    // Incremement this with each structural class change
    private static final long serialVersionUID = 1L;
    
    private String message = "Hello From JSF Managed Bean";
    private String dropdownSelection;
    private String category_Id;

    @Inject
    private ICategoryEAO eao;

    public String getDropdownSelection() {
        return dropdownSelection;
    }

    public void setDropdownSelection(String dropdownSelection) {
        this.dropdownSelection = dropdownSelection;
    }
    
    public String processDropdownSelection(){
        eao.getAllCategoryIds();
        //return "productsListPage";
        return "mainTemplate";
    }
    
    /**
     * Creates a new instance of SampleBean
     */
    public CategoryBean() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public List<Category> getAllCategories(){
        return eao.getAllCategories();
    }
    
    public List<Category> getAllCategoryIds(){
        return eao.getAllCategoryIds();
    }
    
    public String getCategory(String id){
        return eao.getCategoryById(new Integer(id));
    }
    
    public String getCategory_Id() {
        return category_Id;
    }

    public void setUser_Id(String category_Id) {
        this.category_Id = category_Id;
    } 
    
}
