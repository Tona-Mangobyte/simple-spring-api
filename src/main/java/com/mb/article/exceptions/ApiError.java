package com.mb.article.exceptions;

@Deprecated
public record ApiError(Boolean success, String message) {}
