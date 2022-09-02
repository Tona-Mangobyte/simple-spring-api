package com.mb.article.api.controllers;

import com.mb.article.api.request.CategoryRequest;
import com.mb.article.api.response.ListResponse;
import com.mb.article.api.response.ObjectResponse;
import com.mb.article.models.Category;
import com.mb.article.services.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController<Category> {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public ListResponse<Category> getAll() {
        return this.listResponse("request success", this.categoryService.findAll());
    }

    @GetMapping("/{id}")
    public ObjectResponse<Category> getById(@PathVariable("id") Long id) {
        return this.response("request success", this.categoryService.findOne(id));
    }

    @PostMapping
    public ObjectResponse<Category> create(@RequestBody CategoryRequest categoryRequest) {
        return this.response("request success", this.categoryService.create(categoryRequest));
    }
}
