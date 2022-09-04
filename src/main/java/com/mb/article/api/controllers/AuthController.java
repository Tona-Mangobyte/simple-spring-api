package com.mb.article.api.controllers;

import com.mb.article.api.request.JwtRequest;
import com.mb.article.api.response.AuthResponse;
import com.mb.article.api.response.ObjectResponse;
import com.mb.article.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController extends BaseController<AuthResponse> {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ObjectResponse<AuthResponse> auth(@RequestBody JwtRequest auth) {
        return this.response("Authentication is success", authService.authentication(auth));
    }
}
