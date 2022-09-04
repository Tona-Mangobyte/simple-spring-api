package com.mb.article.api.request;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class RequestPaging extends PageRequest {

    protected RequestPaging(int page, int size, Sort sort) {
        super(page, size, sort);
    }

    public static RequestPaging of(int page, int size) {
        return of(page - 1, size, Sort.unsorted());
    }

    public static RequestPaging of(int page, int size, Sort sort) {
        return new RequestPaging(page, size, sort);
    }

    public static RequestPaging of(int page, int size, Sort.Direction direction, String... properties) {
        return of(page, size, Sort.by(direction, properties));
    }

    public static RequestPaging ofSize(int pageSize) {
        return RequestPaging.of(0, pageSize);
    }

    @Override
    public int getPageNumber() {
        return super.getPageNumber() + 1;
    }
}
