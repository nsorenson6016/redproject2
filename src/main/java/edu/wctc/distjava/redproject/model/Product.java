/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.redproject.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Neal Sorenson
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.productId = :productId"),
    @NamedQuery(name = "Product.findByShortDescription", query = "SELECT p FROM Product p WHERE p.shortDescription = :shortDescription"),
    @NamedQuery(name = "Product.findByCategoryId", query = "SELECT p FROM Product p WHERE p.categoryId = :categoryId"),
    @NamedQuery(name = "Product.findByLongDescription", query = "SELECT p FROM Product p WHERE p.longDescription = :longDescription"),
    @NamedQuery(name = "Product.findByImageFile", query = "SELECT p FROM Product p WHERE p.imageFile = :imageFile"),
    @NamedQuery(name = "Product.findByStartDate", query = "SELECT p FROM Product p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "Product.findByEndDate", query = "SELECT p FROM Product p WHERE p.endDate = :endDate"),
    @NamedQuery(name = "Product.findByBuyNowPrice", query = "SELECT p FROM Product p WHERE p.buyNowPrice = :buyNowPrice"),
    @NamedQuery(name = "Product.findByHighBidId", query = "SELECT p FROM Product p WHERE p.highBidId = :highBidId"),
    @NamedQuery(name = "Product.findByBidCount", query = "SELECT p FROM Product p WHERE p.bidCount = :bidCount"),
    @NamedQuery(name = "Product.findByDonatorId", query = "SELECT p FROM Product p WHERE p.donatorId = :donatorId")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_id")
    private Integer productId;
    @Size(max = 40)
    @Column(name = "short_description")
    private String shortDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "category_id")
    private int categoryId;
    @Size(max = 250)
    @Column(name = "long_description")
    private String longDescription;
    @Size(max = 45)
    @Column(name = "image_file")
    private String imageFile;
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "buy_now_price")
    private Long buyNowPrice;
    @Column(name = "high_bid_id")
    private Integer highBidId;
    @Column(name = "bid_count")
    private Integer bidCount;
    @Column(name = "donator_id")
    private Integer donatorId;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Product(Integer productId, int categoryId) {
        this.productId = productId;
        this.categoryId = categoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(Long buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public Integer getHighBidId() {
        return highBidId;
    }

    public void setHighBidId(Integer highBidId) {
        this.highBidId = highBidId;
    }

    public Integer getBidCount() {
        return bidCount;
    }

    public void setBidCount(Integer bidCount) {
        this.bidCount = bidCount;
    }

    public Integer getDonatorId() {
        return donatorId;
    }

    public void setDonatorId(Integer donatorId) {
        this.donatorId = donatorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", shortDescription=" + shortDescription + ", categoryId=" + categoryId + ", longDescription=" + longDescription + ", imageFile=" + imageFile + ", startDate=" + startDate + ", endDate=" + endDate + ", buyNowPrice=" + buyNowPrice + ", highBidId=" + highBidId + ", bidCount=" + bidCount + ", donatorId=" + donatorId + '}';
    }
}
