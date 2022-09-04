package com.mb.article.exceptions;

import java.util.Map;

@Deprecated
public record ApiValidationError(Boolean success, String message, Map<String, String> errors) {}
