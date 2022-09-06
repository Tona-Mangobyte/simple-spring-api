package com.mb.article.services.impl;

import com.mb.article.api.request.AuthRequest;
import com.mb.article.api.response.AuthResponse;
import com.mb.article.models.User;
import com.mb.article.redis.model.AccessToken;
import com.mb.article.redis.services.AccessTokenService;
import com.mb.article.security.JwtTokenUtil;
import com.mb.article.services.AuthService;
import com.mb.article.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    UserService userService;

    @Autowired
    AccessTokenService accessTokenService;

    @Override
    public AuthResponse authentication(AuthRequest auth) {
        try {
            User user = userService.findByUsername(auth.username());
            UserDetails userDetails = userDetailsService.loadUserByUsername(auth.username());
            this.authenticate(auth.username(), auth.password());
            AuthResponse authResponse = jwtTokenUtil.generateToken(userDetails);
            AccessToken accessToken = new AccessToken();
            accessToken.setId(user.getId()+":"+UUID.randomUUID());
            accessToken.setUserId(user.getId());
            accessToken.setToken(authResponse.accessToken());
            accessTokenService.save(accessToken);
            return authResponse;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
