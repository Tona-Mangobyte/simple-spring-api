package com.mb.article.services.impl;

import com.mb.article.api.request.JwtRequest;
import com.mb.article.security.JwtTokenUtil;
import com.mb.article.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    public String authentication(JwtRequest auth) {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(auth.username());
            authenticate(auth.username(), auth.password());
            String token = jwtTokenUtil.generateToken(userDetails);
            return "Bearer " + token;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
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
