package com.fluxexample.controller;

import com.fluxexample.domain.Category;
import com.fluxexample.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("/api/v1/categories")
    public Flux<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @RequestMapping("api/v1/categories/{id}")
    public Mono<Category> getCategoryById(@PathVariable String id) {
        return categoryRepository.findById(id);
    }
}
