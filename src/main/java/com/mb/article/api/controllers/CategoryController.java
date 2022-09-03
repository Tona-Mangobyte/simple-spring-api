package com.mb.article.api.controllers;

import com.mb.article.api.request.CategoryRequest;
import com.mb.article.api.request.RequestPaging;
import com.mb.article.api.response.ListResponse;
import com.mb.article.api.response.ObjectResponse;
import com.mb.article.models.Category;
import com.mb.article.services.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController extends BaseController<Category> {
    private final CategoryService categoryService;
    public CategoryController(final CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public ListResponse getAll(
            @RequestParam(defaultValue = "1", required = false) Integer page,
            @RequestParam(defaultValue = "30", required = false) Integer limit) {
        return this.listResponse("request success",
                this.categoryService.findPaging(RequestPaging.of(page - 1, limit)));
    }

    @GetMapping("{id}")
    public ObjectResponse<Category> getById(@PathVariable("id") Long id) {
        return this.response("request success", this.categoryService.findOne(id));
    }

    @PostMapping
    public ObjectResponse<Category> create(@RequestBody CategoryRequest categoryRequest) {
        return this.response("request success", this.categoryService.create(categoryRequest));
    }
}
