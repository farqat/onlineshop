package kz.onlineshop.onlineshop.api;

import kz.onlineshop.onlineshop.entity.Category;
import kz.onlineshop.onlineshop.entity.Products;
import kz.onlineshop.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Products> allProducts() {


        return service.getAllProducts();


    }

    @GetMapping("/products/filter")
    public List<Products> findByCategory(
            @RequestParam(value = "category", required = false) Category category,
            @RequestParam(value = "price", required = false) Double price,
            @RequestParam(value = "productname", required = false) String productname
    ) {

        if (category != null) {
            if (price != null) {
                if (productname != null) {
                    return service.findByCategoryAndPriceAndProductName(category, price, productname);
                } else {
                    return service.findByCategoryAndPrice(category, price);
                }
            } else {
                return service.findByCategory(category);
            }
        } else if (price != null) {
            return service.findByPrice(price);
        } else if (productname != null) {
            return service.findByProductName(productname);
        } else {
            return service.getAllProducts();
        }

    }

    @PostMapping("/products")
    public Products addProducts(@RequestBody Products products) {

        return service.addProducts(products);

    }

    @GetMapping("/products/{id}")
    public Optional<Products> getProductsById(@PathVariable("id") long id) {

        return service.getProductsById(id);

    }

    @PutMapping("/products/{id}")
    public Products updateProduct(@PathVariable("id") long id, @RequestBody Products products) {

        return service.updateProduct(products);

    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        return service.deleteProduct(id);

    }


}
