package com.mb.article.api.request;

import javax.validation.constraints.NotBlank;

public record ArticleRequest(Long id, @NotBlank(message = "Title is required") String title,
                             @NotBlank(message = "Content is required") String content) {}
