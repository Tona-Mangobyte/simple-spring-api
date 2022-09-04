package com.mb.article.api.controllers;

import com.mb.article.api.request.ArticleRequest;
import com.mb.article.api.request.RequestPaging;
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
    public ListResponse getAll(@RequestParam(defaultValue = "1", required = false) Integer page,
                               @RequestParam(defaultValue = "30", required = false) Integer limit) {
        return this.listResponse("request success",
                this.articleService.findPaging(RequestPaging.of(page, limit)));
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
