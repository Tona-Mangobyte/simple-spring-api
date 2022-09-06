package com.mb.article.redis.services.impl;

import com.mb.article.redis.model.AccessToken;
import com.mb.article.redis.repositories.AccessTokenRepository;
import com.mb.article.redis.services.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessTokenServiceImpl implements AccessTokenService {

    @Autowired
    private AccessTokenRepository accessTokenRepository;

    @Override
    public AccessToken save(AccessToken accessToken) {
        return accessTokenRepository.save(accessToken);
    }
}
