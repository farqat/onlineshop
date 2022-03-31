package kz.onlineshop.onlineshop.service;

import kz.onlineshop.onlineshop.entity.Category;
import kz.onlineshop.onlineshop.entity.Products;
import kz.onlineshop.onlineshop.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productrepository;

    public List<Products> getAllProducts() {
        return productrepository.findAll();
    }

    public Products addProducts(Products products) {
        Products product = new Products();
        if (products.getProductCategory().getId() != null) {
            product.setProductName(products.getProductName());
            product.setPrice(products.getPrice());
            product.setProductCategory(products.getProductCategory());
        }

        return productrepository.save(product);
    }

    public Optional<Products> getProductsById(long id) {
        return productrepository.findById(id);
    }

    public Products updateProduct(Products products) {
        return productrepository.save(products);
    }

    public String deleteProduct(long id) {
        productrepository.deleteById(id);
        return "Product with id:  " + id + " was deleted";
    }

    public List<Products> findByCategoryAndPriceAndProductName(Category category, Double price, String productname) {
        return productrepository.findByProductCategoryAndPriceAndProductName(category, price, productname);
    }

    public List<Products> findByCategoryAndPrice(Category category, Double price) {
        return productrepository.findByProductCategoryAndPrice(category, price);
    }

    public List<Products> findByCategory(Category category) {
        return productrepository.findByProductCategory(category);
    }

    public List<Products> findByPrice(Double price) {
        return productrepository.findByPrice(price);
    }

    public List<Products> findByProductName(String productname) {
        return productrepository.findByProductName(productname);
    }
}
