package com.mb.article.services.impl;

import com.mb.article.api.request.CommentRequest;
import com.mb.article.models.Article;
import com.mb.article.models.Comment;
import com.mb.article.repositories.CommentRepository;
import com.mb.article.services.ArticleService;
import com.mb.article.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleService articleService;

    @Override
    public Comment create(Long articleId, CommentRequest commentRequest) {
        Article article = this.articleService.findOne(articleId);
        Comment comment = new Comment();
        comment.setContent(commentRequest.message());
        comment.setArticle(article);
        return this.commentRepository.save(comment);
    }
}
