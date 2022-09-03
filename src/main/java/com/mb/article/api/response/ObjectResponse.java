package com.mb.article.api.response;

public record ObjectResponse<T> (Boolean success, String message, T data) {}

