package edu.wctc.distjava.redproject.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
/**
 *
 * @author Neal Sorenson
 */

@Named("csbean")
@Scope("request")
public class CustServCategoryBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Logger LOG = LoggerFactory.getLogger(CustServCategoryBean.class);
    
    private List<String> categoryList;
    
    public CustServCategoryBean(){
        categoryList = new ArrayList<String>();
            categoryList.add("Buying an item");
            categoryList.add("Selling an item");
            categoryList.add("Registration");
            categoryList.add("Technical Issues"); 
    }
    
    public List<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }
    
        
    /* validation for drop down menu in customer_service page.  If a subject
     * hasn't been chosen, a validation message will appear after the drop
     * down list.
     */
    
    public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
        String choice = value.toString();
        if (choice.equals("Please choose a subject...")){
            FacesMessage invalidMessage = 
                    new FacesMessage("Please choose a subject.",
                    "Subject not chosen");
            throw new ValidatorException(invalidMessage);
        }
}
}
