package edu.wctc.distjava.redproject.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    
    
}
