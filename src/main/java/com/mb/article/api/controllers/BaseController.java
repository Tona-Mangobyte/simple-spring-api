package com.mb.article.api.controllers;

import com.mb.article.api.response.ItemsPagination;
import com.mb.article.api.response.ListResponse;
import com.mb.article.api.response.ObjectResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;
import java.util.Map;

@SecurityRequirement(name = "bearerToken")
public class BaseController {
    protected ListResponse listResponse(String message, ItemsPagination<?> data) {
        return new ListResponse(true, message, data);
    }

    protected ObjectResponse response(String message, Object data) {
        return new ObjectResponse<>(true, message, data);
    }
}
