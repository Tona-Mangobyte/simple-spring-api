package com.mb.article.services;

import com.mb.article.api.request.CategoryRequest;
import com.mb.article.api.request.RequestPaging;
import com.mb.article.api.response.ItemsPagination;
import com.mb.article.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    ItemsPagination<Category> findPaging(RequestPaging paging);
    Category findOne(Long id);

    Category create(CategoryRequest categoryRequest);
}
