package com.mb.article.redis.services;

import com.mb.article.redis.model.AccessToken;

import java.util.List;

public interface AccessTokenService {

    List<AccessToken> findAllByUserId(Long userId);
    AccessToken save(AccessToken accessToken);
    void deleteById(String id);
}
