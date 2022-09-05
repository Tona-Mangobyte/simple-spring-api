package com.mb.article.services.impl;

import com.mb.article.services.TranslatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@Slf4j
public class TranslatorServiceImpl implements TranslatorService {


    @Autowired
    private ResourceBundleMessageSource messageSource;

    @Override
    public String translate(String key) {
        Locale locale = LocaleContextHolder.getLocale();
        log.info("Current Language: {}", locale);
        return this.messageSource.getMessage(key, null, locale);
    }
}
