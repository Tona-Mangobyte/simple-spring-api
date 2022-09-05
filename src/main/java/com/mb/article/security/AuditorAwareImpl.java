package com.mb.article.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Slf4j
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("authentication isAuthenticated: {} ", authentication.isAuthenticated());
        log.info("authentication getPrincipal: {} ", authentication.getPrincipal());
        log.info("authentication getDetails: {} ", authentication.getDetails());
        log.info("authentication getName: {} ", authentication.getName());
        return Optional.ofNullable(authentication.getName());
    }


}
