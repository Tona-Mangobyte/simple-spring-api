package com.mb.article.redis.model;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("AccessToken")
public class AccessToken implements Serializable {
    String id;
    Long userId;
    String token;

    public AccessToken(String id, Long userId, String token) {
        this.id = id;
        this.userId = userId;
        this.token = token;
    }



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
