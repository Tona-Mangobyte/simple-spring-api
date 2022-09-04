package com.mb.article.services;

import com.mb.article.api.request.AuthRequest;
import com.mb.article.api.response.AuthResponse;

public interface AuthService {
    AuthResponse authentication(AuthRequest auth);
}
