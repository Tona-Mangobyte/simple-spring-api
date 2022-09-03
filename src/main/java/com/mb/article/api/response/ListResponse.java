package com.mb.article.api.response;

import java.util.List;

public record ListResponse(Boolean success, String message, ItemsPagination<?> data) {}
