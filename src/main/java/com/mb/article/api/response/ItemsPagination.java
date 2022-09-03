package com.mb.article.api.response;

import java.util.List;

public record ItemsPagination<T>(List<T> items, PagingResponse pagination) {}
