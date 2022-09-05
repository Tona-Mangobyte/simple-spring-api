package com.mb.article.repositories;

import com.mb.article.models.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByArticleId(Long articleId);
    Page<Comment> findAllByArticleId(Long articleId, Pageable pageable);
}
