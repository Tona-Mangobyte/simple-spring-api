package com.mb.article.api.controllers;

import com.mb.article.api.request.AuthRequest;
import com.mb.article.api.response.AuthResponse;
import com.mb.article.api.response.ObjectResponse;
import com.mb.article.services.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Tag(name = "Auth")
public class AuthController extends BaseController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ObjectResponse<AuthResponse> auth(@Valid @RequestBody AuthRequest auth) {
        return this.response("Authentication is success", authService.authentication(auth));
    }
}
