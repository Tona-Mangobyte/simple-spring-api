package com.mb.article.services.impl;

import com.mb.article.api.request.CommentRequest;
import com.mb.article.api.request.RequestPaging;
import com.mb.article.api.response.ItemsPagination;
import com.mb.article.api.response.PagingResponse;
import com.mb.article.models.Article;
import com.mb.article.models.Comment;
import com.mb.article.repositories.CommentRepository;
import com.mb.article.services.ArticleService;
import com.mb.article.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleService articleService;

    @Override
    public List<Comment> findAllByArticleId(Long articleId) {
        return this.commentRepository.findAllByArticleId(articleId);
    }

    @Override
    public ItemsPagination<Comment> findAllByArticleIdAndPaging(Long articleId, RequestPaging paging) {
        Page<Comment> commentPage = this.commentRepository.findAllByArticleId(articleId, paging);
        return new ItemsPagination<>(commentPage.stream().toList()
                , new PagingResponse(commentPage.getNumber(), paging.getPageSize()
                , commentPage.getTotalPages(), commentPage.hasNext(), commentPage.hasPrevious()));
    }

    @Override
    public Comment create(Long articleId, CommentRequest commentRequest) {
        Article article = this.articleService.findOne(articleId);
        Comment comment = new Comment();
        comment.setContent(commentRequest.message());
        comment.setArticle(article);
        return this.commentRepository.save(comment);
    }
}
