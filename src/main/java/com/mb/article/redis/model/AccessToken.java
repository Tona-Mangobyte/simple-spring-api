package com.mb.article.redis.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@RedisHash("AccessToken")
@Entity
@Data
@RequiredArgsConstructor
public class AccessToken implements Serializable {
    @Id
    String id;
    Long userId;
    String token;
}
