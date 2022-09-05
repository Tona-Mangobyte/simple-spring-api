package com.mb.article.services;

import com.mb.article.api.request.CommentRequest;
import com.mb.article.models.Comment;

import java.util.List;

public interface CommentService {
    // List<Comment> findAllByArticleId(Long id);

    Comment create(Long articleId, CommentRequest commentRequest);
}
