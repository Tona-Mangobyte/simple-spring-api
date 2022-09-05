package com.mb.article.api.controllers;

import com.mb.article.api.response.ItemsPagination;
import com.mb.article.api.response.ListResponse;
import com.mb.article.api.response.ObjectResponse;
import com.mb.article.services.TranslatorService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@SecurityRequirement(name = "bearerToken")
@SecurityRequirement(name = "lang")
public class BaseController {

    @Autowired
    private TranslatorService translatorService;

    protected ListResponse listResponse(String message, ItemsPagination<?> data) {
        return new ListResponse(true, this.translatorService.translate(message), data);
    }

    protected ObjectResponse response(String message, Object data) {
        return new ObjectResponse<>(true, this.translatorService.translate(message), data);
    }
}
