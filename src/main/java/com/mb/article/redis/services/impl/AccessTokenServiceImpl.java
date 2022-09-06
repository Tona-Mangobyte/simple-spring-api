package com.mb.article.redis.services.impl;

import com.mb.article.redis.model.AccessToken;
import com.mb.article.redis.repositories.AccessTokenRepository;
import com.mb.article.redis.services.AccessTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class AccessTokenServiceImpl implements AccessTokenService {

    @Autowired
    private AccessTokenRepository accessTokenRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public List<AccessToken> findAllByUserId(Long userId) {
        RedisConnection redisConnection = redisTemplate.getConnectionFactory().getConnection();
        ScanOptions scanOptions = ScanOptions.scanOptions().match("AccessToken:"+userId+":*").build();
        log.info("Scan Option getCount {}", scanOptions.getCount());
        log.info("Scan Option getCount {}", scanOptions);

        Cursor c = redisConnection.scan(scanOptions);
        List<String> ids = new ArrayList<>();
        while (c.hasNext()) {
            String id = new String((byte[]) c.next());
            log.info(id);
            ids.add(id.split("Token:")[1]);
        }
        return this.accessTokenRepository.findAllById(ids);
    }

    @Override
    public AccessToken save(AccessToken accessToken) {
        return accessTokenRepository.save(accessToken);
    }

    @Override
    public void deleteById(String id) {
        this.accessTokenRepository.deleteById(id);
    }
}
