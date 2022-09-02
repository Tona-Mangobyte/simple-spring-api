package com.mb.article.api.response;

import java.util.List;

public class ListResponse<T> extends BaseResponse {
    List<T> data;


    public ListResponse() {}
    public ListResponse(List<T> data) {
        this.data = data;
    }
    public ListResponse(Boolean success, String message, List<T> data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }


    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
