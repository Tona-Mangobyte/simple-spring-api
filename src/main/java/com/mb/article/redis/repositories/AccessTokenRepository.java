package com.mb.article.redis.repositories;

import com.mb.article.redis.model.AccessToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessTokenRepository extends CrudRepository<AccessToken, String> {
}
