package com.mb.article.services;

import com.mb.article.api.request.CategoryRequest;
import com.mb.article.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findOne(Long id);

    Category create(CategoryRequest categoryRequest);
}
