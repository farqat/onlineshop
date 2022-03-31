package kz.onlineshop.onlineshop.entity;

import javax.persistence.*;

@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prod_id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "price", nullable = false)
    private Double price;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productid")
    private Category productCategory;

    public Products() {
    }

    public Products(String productName, Double price, Category productCategory) {
        this.productName = productName;
        this.price = price;
        this.productCategory = productCategory;
    }



    public Long getProd_id() {
        return prod_id;
    }

    public void setProd_id(Long prod_id) {
        this.prod_id = prod_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }
}
