package com.mb.article.api.request;

import javax.validation.constraints.NotBlank;

public record CommentRequest(@NotBlank(message = "Message is required") String message) {}
