/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject2.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Neal
 */
@Entity
@Table(name = "bid")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bid.findAll", query = "SELECT b FROM Bid b"),
    @NamedQuery(name = "Bid.findByBidId", query = "SELECT b FROM Bid b WHERE b.bidId = :bidId"),
    @NamedQuery(name = "Bid.findByAmount", query = "SELECT b FROM Bid b WHERE b.amount = :amount")})
public class Bid implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bid_id")
    private Integer bidId;
    @Column(name = "amount")
    private Long amount;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne
    private Product productId;
    @JoinColumn(name = "bidder_username", referencedColumnName = "username")
    @ManyToOne
    private Users bidderUsername;

    public Bid() {
    }

    public Bid(Integer bidId) {
        this.bidId = bidId;
    }

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Users getBidderUsername() {
        return bidderUsername;
    }

    public void setBidderUsername(Users bidderUsername) {
        this.bidderUsername = bidderUsername;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bidId != null ? bidId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bid)) {
            return false;
        }
        Bid other = (Bid) object;
        if ((this.bidId == null && other.bidId != null) || (this.bidId != null && !this.bidId.equals(other.bidId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.wctc.distjava.redproject2.model.Bid[ bidId=" + bidId + " ]";
    }
    
}
