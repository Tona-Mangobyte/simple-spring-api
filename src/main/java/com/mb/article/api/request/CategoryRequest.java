package com.mb.article.api.request;

import javax.validation.constraints.NotBlank;

public record CategoryRequest(Long id, @NotBlank(message = "Name is required") String name) {}
