package com.mb.article.services.impl;

import com.mb.article.api.request.CategoryRequest;
import com.mb.article.models.Category;
import com.mb.article.repositories.CategoryRepository;
import com.mb.article.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findOne(Long id) {
        return this.categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category create(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setId(categoryRequest.id());
        category.setName(categoryRequest.name());
        return this.categoryRepository.save(category);
    }


}
