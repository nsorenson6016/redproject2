/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject.controller;

import edu.wctc.distjava.redproject.eao.IBidEAO;
import edu.wctc.distjava.redproject.model.Product;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author scottodya
 */
@Named(value = "bidBean")
@Dependent
public class bidBean {
    private String bid_id;
    Product product;
    IBidEAO ieao;
    
    /**
     * Creates a new instance of bidBean
     */
    public bidBean() {
    }
    
    public void setBidId(String bid_id){
        this.bid_id = bid_id;
    }
    
    public String getBidId(){
        return bid_id;
    }
    
    public void createNewBid(String shortDescription, String longDescription, 
            String end_date, String starting_bid){
        //ieao.create(Bid bid);
    }
}
