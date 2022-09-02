package com.mb.article.api.controllers;

import com.mb.article.api.request.ArticleRequest;
import com.mb.article.api.response.ListResponse;
import com.mb.article.api.response.ObjectResponse;
import com.mb.article.models.Article;
import com.mb.article.services.ArticleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/article")
public class ArticleController extends BaseController<Article> {
    private final ArticleService articleService;

    public ArticleController(final ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public ListResponse<Article> getAll() {
        return this.listResponse("request success", this.articleService.findAll());
    }

    @GetMapping("{id}")
    public ObjectResponse<Article> getById(@PathVariable("id") Long id) {
        return this.response("request success", this.articleService.findOne(id));
    }

    @PostMapping
    public ObjectResponse<Article> create(@RequestBody ArticleRequest articleRequest) {
        return this.response("request success", this.articleService.create(articleRequest));
    }
}
