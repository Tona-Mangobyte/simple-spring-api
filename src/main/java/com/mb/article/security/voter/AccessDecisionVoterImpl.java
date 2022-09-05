package com.mb.article.security.voter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Slf4j
public class AccessDecisionVoterImpl implements AccessDecisionVoter<Object> {
    private String anonymousUserName ="anonymousUser";

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class clazz) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> collection) {
        final String username = (authentication.getPrincipal() == null ) ? "NONE_PROVIDED" : authentication.getName();
        log.info("authentication {}", username);
        /*if(StringUtils.equalsAnyIgnoreCase(username, anonymousUserName)){
            log.warn("deny access {}", username);
            return ACCESS_DENIED;
        }*/
        return ACCESS_GRANTED;
    }
}
