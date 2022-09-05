package com.mb.article.services;

import com.mb.article.api.request.ArticleRequest;
import com.mb.article.api.request.CommentRequest;
import com.mb.article.api.request.RequestPaging;
import com.mb.article.api.response.ArticleCommentsResponse;
import com.mb.article.api.response.ItemsPagination;
import com.mb.article.models.Article;
import com.mb.article.models.Comment;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();

    ItemsPagination<Article> findPaging(RequestPaging paging);

    Article findOne(Long id);

    Article create(ArticleRequest articleRequest);

    Article createComment(Long articleId, CommentRequest commentRequest);

    List<Comment> findAllCommentsByArticleId(Long articleId);

    ArticleCommentsResponse findAllByArticleIdAndPaging(Long articleId, RequestPaging paging);
}
