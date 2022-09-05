package com.mb.article.services;

import com.mb.article.api.request.CommentRequest;
import com.mb.article.api.request.RequestPaging;
import com.mb.article.api.response.ItemsPagination;
import com.mb.article.models.Article;
import com.mb.article.models.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAllByArticleId(Long articleId);

    ItemsPagination<Comment> findAllByArticleIdAndPaging(Long articleId, RequestPaging paging);

    Comment create(Long articleId, CommentRequest commentRequest);
}
