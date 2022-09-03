package com.mb.article.api.response;

public record PagingResponse(Integer page, Integer limit, Integer total, Boolean next, Boolean previous) {}
