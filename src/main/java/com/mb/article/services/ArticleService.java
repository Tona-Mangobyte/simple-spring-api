package com.mb.article.services;

import com.mb.article.api.request.ArticleRequest;
import com.mb.article.api.request.RequestPaging;
import com.mb.article.api.response.ItemsPagination;
import com.mb.article.models.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();

    ItemsPagination<Article> findPaging(RequestPaging paging);

    Article findOne(Long id);

    Article create(ArticleRequest articleRequest);
}
