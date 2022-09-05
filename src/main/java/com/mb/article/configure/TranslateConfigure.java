package com.mb.article.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

@Configuration
@Slf4j
public class TranslateConfigure extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String headerLang = request.getHeader("Accept-Language");
        log.info("Get Language from header {}", headerLang);
        if (headerLang == null || headerLang.isEmpty()) {
            return Locale.getDefault();
        } else if (headerLang.equals("en")) {
            return Locale.ENGLISH;
        } else if (headerLang.equals("ja")) {
            return Locale.JAPAN;
        }
        return Locale.lookup(Locale.LanguageRange.parse(headerLang), List.of(Locale.ENGLISH, Locale.JAPAN));
    }

    @Bean
    ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true);
        return messageSource;
    }
}
