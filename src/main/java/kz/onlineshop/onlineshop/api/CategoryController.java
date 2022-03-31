package kz.onlineshop.onlineshop.api;

import kz.onlineshop.onlineshop.entity.Category;
import kz.onlineshop.onlineshop.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryRepository repository;

    @GetMapping
    public List<Category> getAllCategory(){
        return repository.findAll();
    }
}
