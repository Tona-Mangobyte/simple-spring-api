package com.mb.article.services;

import com.mb.article.api.request.RequestPaging;
import com.mb.article.api.request.UserRequest;
import com.mb.article.api.response.ItemsPagination;
import com.mb.article.models.User;

public interface UserService {
    ItemsPagination<User> findPaging(RequestPaging paging);

    User findOne(Long id);

    User create(UserRequest userRequest);
}
