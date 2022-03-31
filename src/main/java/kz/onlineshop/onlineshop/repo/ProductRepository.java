package kz.onlineshop.onlineshop.repo;

import kz.onlineshop.onlineshop.entity.Category;
import kz.onlineshop.onlineshop.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Long> {

    List<Products> findByProductCategory(Category category);

    List<Products> findByPrice(Double price);

    List<Products> findByProductName(String productname);

    List<Products> findByProductCategoryAndPriceAndProductName(Category category, Double price, String productname);

    List<Products> findByProductCategoryAndPrice(Category category, Double price);


}
