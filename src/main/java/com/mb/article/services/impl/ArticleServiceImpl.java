package com.mb.article.services.impl;

import com.mb.article.api.request.ArticleRequest;
import com.mb.article.models.Article;
import com.mb.article.repositories.ArticleRepository;
import com.mb.article.services.ArticleService;
import org.springframework.stereotype.Service;

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
    public Article findOne(Long id) {
        return this.articleRepository.findById(id).orElse(null);
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
