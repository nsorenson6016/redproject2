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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author scottodya
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.productId = :productId"),
    @NamedQuery(name = "Product.findByShortDescription", query = "SELECT p FROM Product p WHERE p.shortDescription = :shortDescription"),
    @NamedQuery(name = "Product.findByLongDescription", query = "SELECT p FROM Product p WHERE p.longDescription = :longDescription"),
    @NamedQuery(name = "Product.findByImageFile1", query = "SELECT p FROM Product p WHERE p.imageFile1 = :imageFile1"),
    @NamedQuery(name = "Product.findByImageFile2", query = "SELECT p FROM Product p WHERE p.imageFile2 = :imageFile2"),
    @NamedQuery(name = "Product.findByImageFile3", query = "SELECT p FROM Product p WHERE p.imageFile3 = :imageFile3"),
    @NamedQuery(name = "Product.findByStartDate", query = "SELECT p FROM Product p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "Product.findByEndDate", query = "SELECT p FROM Product p WHERE p.endDate = :endDate"),
    @NamedQuery(name = "Product.findByBuyNowPrice", query = "SELECT p FROM Product p WHERE p.buyNowPrice = :buyNowPrice")})
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
    @Size(max = 250)
    @Column(name = "long_description")
    private String longDescription;
    @Size(max = 45)
    @Column(name = "image_file1")
    private String imageFile1;
    @Size(max = 45)
    @Column(name = "image_file2")
    private String imageFile2;
    @Size(max = 45)
    @Column(name = "image_file3")
    private String imageFile3;
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "buy_now_price")
    private Long buyNowPrice;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @ManyToOne
    private Category categoryId;
    @JoinColumn(name = "donating_username", referencedColumnName = "username")
    @ManyToOne
    private Users donatingUsername;

    public Product() {
    }

//    public Product(Integer productId) {
//        this.productId = productId;
//    }

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

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getImageFile1() {
        return imageFile1;
    }

    public void setImageFile1(String imageFile1) {
        this.imageFile1 = imageFile1;
    }

    public String getImageFile2() {
        return imageFile2;
    }

    public void setImageFile2(String imageFile2) {
        this.imageFile2 = imageFile2;
    }

    public String getImageFile3() {
        return imageFile3;
    }

    public void setImageFile3(String imageFile3) {
        this.imageFile3 = imageFile3;
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

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Users getDonatingUsername() {
        return donatingUsername;
    }

    public void setDonatingUsername(Users donatingUsername) {
        this.donatingUsername = donatingUsername;
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
        return "model.Product[ productId=" + productId + " ]";
    }
    
}
