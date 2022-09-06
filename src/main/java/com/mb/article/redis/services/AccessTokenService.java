package com.mb.article.redis.services;

import com.mb.article.redis.model.AccessToken;

public interface AccessTokenService {
    AccessToken save(AccessToken accessToken);
}
