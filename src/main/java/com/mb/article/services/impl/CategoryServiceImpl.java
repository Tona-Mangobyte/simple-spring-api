package com.mb.article.services.impl;

import com.mb.article.api.request.CategoryRequest;
import com.mb.article.api.request.RequestPaging;
import com.mb.article.api.response.ItemsPagination;
import com.mb.article.api.response.PagingResponse;
import com.mb.article.models.Category;
import com.mb.article.repositories.CategoryRepository;
import com.mb.article.services.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    public CategoryServiceImpl(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public ItemsPagination<Category> findPaging(RequestPaging paging) {
        Page<Category> categoryPage = this.categoryRepository.findAll(paging);
        return new ItemsPagination<>(categoryPage.stream().toList()
                , new PagingResponse(categoryPage.getNumber() + 1, paging.getPageSize()
                , categoryPage.getTotalPages(), categoryPage.hasNext(), categoryPage.hasPrevious()));
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
