package com.mb.article.api.response;

import com.mb.article.models.Article;
import com.mb.article.models.Comment;

public record ArticleCommentsResponse(Article article, ItemsPagination<Comment> comments) {}
