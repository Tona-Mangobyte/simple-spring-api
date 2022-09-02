package com.mb.article.api.response;

import java.util.List;

public class ObjectResponse<T> extends BaseResponse {
    T data;

    public ObjectResponse() {}
    public ObjectResponse(T data) {
        this.data = data;
    }
    public ObjectResponse(Boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

