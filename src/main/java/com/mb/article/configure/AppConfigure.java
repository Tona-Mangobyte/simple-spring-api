package com.mb.article.configure;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mapping.context.PersistentEntities;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.validation.SmartValidator;

// @Configuration
public class AppConfigure {
    @Bean
    public ValidatingRepositoryEventListener preSaveValidator(
            @Qualifier("defaultValidator") SmartValidator validator,
            ObjectFactory<PersistentEntities> persistentEntitiesFactory) {
        ValidatingRepositoryEventListener eventListener =
                new ValidatingRepositoryEventListener(persistentEntitiesFactory);
        eventListener.addValidator("beforeCreate", validator);
        eventListener.addValidator("beforeSave", validator);
        return eventListener;
    }
}
