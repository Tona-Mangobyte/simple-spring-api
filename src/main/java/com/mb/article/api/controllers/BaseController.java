package com.mb.article.api.controllers;

import com.mb.article.api.response.ListResponse;
import com.mb.article.api.response.ObjectResponse;

import java.util.List;

public class BaseController<T> {
    protected ListResponse<T> listResponse(String message, List<T> data) {
        return new ListResponse<>(true, message, data);
    }

    protected ObjectResponse<T> response(String message, T data) {
        return new ObjectResponse<>(true, message, data);
    }
}
