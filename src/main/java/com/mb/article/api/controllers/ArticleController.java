package com.mb.article.api.controllers;

import com.mb.article.api.request.ArticleRequest;
import com.mb.article.api.request.CommentRequest;
import com.mb.article.api.request.RequestPaging;
import com.mb.article.api.response.ListResponse;
import com.mb.article.api.response.ObjectResponse;
import com.mb.article.models.Article;
import com.mb.article.services.ArticleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/article")
@Tag(name = "Articles")
@Slf4j
public class ArticleController extends BaseController<Article> {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public ListResponse getAll(@RequestParam(defaultValue = "1", required = false) Integer page,
                               @RequestParam(defaultValue = "30", required = false) Integer limit) {
        return this.listResponse("Request is success",
                this.articleService.findPaging(RequestPaging.of(page, limit)));
    }

    @GetMapping("{id}")
    public ObjectResponse<Article> getById(@PathVariable("id") Long id) {
        return this.response("Request is success", this.articleService.findOne(id));
    }

    @PostMapping
    public ObjectResponse<Article> create(@Valid @RequestBody ArticleRequest articleRequest) {
        return this.response("Request is success", this.articleService.create(articleRequest));
    }

    @PostMapping("{id}/comment")
    public ObjectResponse<Article> commentOnArticle(@PathVariable("id") Long id, @Valid @RequestBody CommentRequest commentRequest) {
        log.info("Article Id: {}", id);
        return this.response("Request is success", this.articleService.createComment(id, commentRequest));
    }
}
