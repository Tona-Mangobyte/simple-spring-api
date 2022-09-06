package com.mb.article.api.controllers;

import com.mb.article.api.request.AuthRequest;
import com.mb.article.api.response.AuthResponse;
import com.mb.article.api.response.ObjectResponse;
import com.mb.article.redis.model.AccessToken;
import com.mb.article.redis.repositories.AccessTokenRepository;
import com.mb.article.redis.services.AccessTokenService;
import com.mb.article.services.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Tag(name = "Auth")
@Slf4j
public class AuthController extends BaseController {
    @Autowired
    private AuthService authService;

    @Autowired
    private AccessTokenService accessTokenService;

    @Autowired
    private AccessTokenRepository accessTokenRepository;

    @PostMapping("/login")
    public ObjectResponse<AuthResponse> auth(@Valid @RequestBody AuthRequest auth) {
        return this.response("request.success", authService.authentication(auth));
    }

    @GetMapping("{userId}/tokens")
    public ObjectResponse getByToken(@PathVariable("userId") Long userId) {
        List<AccessToken> accessToken = accessTokenService.findAllByUserId(userId);
        log.info(" accessToken {}", accessToken);
        log.info(" accessToken isEmpty {}", accessToken.isEmpty());
        return this.response("request.success", accessToken);
    }
}
