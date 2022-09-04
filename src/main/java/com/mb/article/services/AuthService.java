package com.mb.article.services;

import com.mb.article.api.request.JwtRequest;
import com.mb.article.api.response.AuthResponse;

public interface AuthService {
    AuthResponse authentication(JwtRequest auth);
}
