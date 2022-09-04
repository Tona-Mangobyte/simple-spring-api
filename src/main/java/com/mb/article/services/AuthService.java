package com.mb.article.services;

import com.mb.article.api.request.JwtRequest;

public interface AuthService {
    String authentication(JwtRequest auth);
}
