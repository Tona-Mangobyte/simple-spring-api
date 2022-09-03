package com.mb.article.services.impl;

import com.mb.article.api.request.ArticleRequest;
import com.mb.article.api.request.RequestPaging;
import com.mb.article.api.response.ItemsPagination;
import com.mb.article.api.response.PagingResponse;
import com.mb.article.models.Article;
import com.mb.article.repositories.ArticleRepository;
import com.mb.article.services.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(final ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAll() {
        return this.articleRepository.findAll();
    }

    @Override
    public ItemsPagination<Article> findPaging(RequestPaging paging) {
        Page<Article> articlePage = this.articleRepository.findAll(paging);
        return new ItemsPagination<>(articlePage.stream().toList()
                , new PagingResponse(paging.getPageNumber(), paging.getPageSize()
                , articlePage.getTotalPages(), articlePage.hasNext(), articlePage.hasPrevious()));
    }

    @Override
    public Article findOne(Long id) {
        return this.articleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Article not found"));
    }

    @Override
    public Article create(ArticleRequest articleRequest) {
        Article article = new Article();
        article.setId(articleRequest.id());
        article.setTitle(articleRequest.title());
        article.setContent(articleRequest.content());
        return this.articleRepository.save(article);
    }
}
