package com.mb.article.api.controllers;

import com.mb.article.api.response.ItemsPagination;
import com.mb.article.api.response.ListResponse;
import com.mb.article.api.response.ObjectResponse;

import java.util.List;
import java.util.Map;

public class BaseController<T> {
    protected ListResponse listResponse(String message, ItemsPagination<T> data) {
        return new ListResponse(true, message, data);
    }

    protected ObjectResponse response(String message, T data) {
        return new ObjectResponse<>(true, message, data);
    }
}
