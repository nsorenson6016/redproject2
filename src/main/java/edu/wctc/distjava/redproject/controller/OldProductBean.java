package edu.wctc.distjava.redproject.controller;

import edu.wctc.distjava.redproject.model.IProductEAO;
import edu.wctc.distjava.redproject.model.Product;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;

/**
 * A sample JSF Managed Bean
 * @author  jlombardo
 * @version 1.00
 */
@Named
@Scope("session")
public class OldProductBean implements Serializable {
    // Incremement this with each structural class change
    private static final long serialVersionUID = 1L;
    
    @Inject
    private IProductEAO ieao;
    
    private String product_id;
    private String product_name;
    private String category_id;
    private String description;
    private String image;
    private String start_date;
    private String end_date;
    private String buy_now_price;
    private String high_bid_id;
    private String bid_count;
    private String donor_id;
    private String winner_id;
    private List<Product> foundProducts;
    private List<String> productNumbers;
    private String selectedProductNumber;
    private Product selectedProduct;
    private Integer dropdownSelection;

    public Product getProductById(String id){
        return ieao.getProductById(new Integer(id));
    }

    public void handleItemSelect(SelectEvent event) {
        
    }
            
    
    public String processDropdownSelection(){
        //System.out.println("category num passed in = " + category);
        //List<Product> list = ieao.productsByCategoryId(new Integer(category));
        foundProducts = ieao.getProductsByCategoryId(dropdownSelection);
        return null;
    }

    public Integer getDropdownSelection() {
        return dropdownSelection;
    }

    public void setDropdownSelection(Integer dropdownSelection) {
        this.dropdownSelection = dropdownSelection;
    }

    public IProductEAO getIeao() {
        return ieao;
    }

    public void setIeao(IProductEAO ieao) {
        this.ieao = ieao;
    }
    
    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getBuy_now_price() {
        return buy_now_price;
    }

    public void setBuy_now_price(String buy_now_price) {
        this.buy_now_price = buy_now_price;
    }

    public String getHigh_bid_id() {
        return high_bid_id;
    }

    public void setHigh_bid_id(String high_bid_id) {
        this.high_bid_id = high_bid_id;
    }

    public String getBid_count() {
        return bid_count;
    }

    public void setBid_count(String bid_count) {
        this.bid_count = bid_count;
    }

    public String getDonor_id() {
        return donor_id;
    }

    public void setDonor_id(String donor_id) {
        this.donor_id = donor_id;
    }

    public String getWinner_id() {
        return winner_id;
    }

    public void setWinner_id(String winner_id) {
        this.winner_id = winner_id;
    }

    public List<Product> getFoundProducts() {
        return foundProducts;
    }

    public void setFoundProducts(List<Product> foundProducts) {
        this.foundProducts = foundProducts;
    }

    public List<String> getProductNumbers() {
        return productNumbers;
    }

    public void setProductNumbers(List<String> productNumbers) {
        this.productNumbers = productNumbers;
    }

    public String getSelectedProductNumber() {
        return selectedProductNumber;
    }

    public void setSelectedProductNumber(String selectedProductNumber) {
        this.selectedProductNumber = selectedProductNumber;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
    
    
    
}
