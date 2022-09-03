package com.mb.article.configure;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mapping.context.PersistentEntities;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.SmartValidator;

import javax.validation.groups.Default;

@Configuration
public class RestRepositoryValidatorConfigure {
    @Bean
    public ValidatingRepositoryEventListener preSaveValidator(
            AnimalValidationGroupAwareValidator validator,
            ObjectFactory<PersistentEntities> persistentEntitiesFactory) {
        ValidatingRepositoryEventListener eventListener =
                new ValidatingRepositoryEventListener(persistentEntitiesFactory);
        eventListener.addValidator("beforeCreate", validator);
        eventListener.addValidator("beforeSave", validator);
        return eventListener;
    }

    @Component
    public static class AnimalValidationGroupAwareValidator
            implements SmartValidator {
        private final SmartValidator delegate;

        public AnimalValidationGroupAwareValidator(
                @Qualifier("defaultValidator") SmartValidator delegate) {
            this.delegate = delegate;
        }

        @Override
        public boolean supports(Class<?> clazz) {
            return true;
        }

        @Override
        public void validate(Object target, Errors errors,
                             Object... validationHints) {
            // If hints are overridden, use those instead
            delegate.validate(target, errors, validationHints);
        }

        @Override
        public void validate(Object target, Errors errors) {
            /*if (target instanceof Animal animal &&
                    Animal.Type.FLYING.equals(animal.getType())) {
                delegate.validate(target, errors,
                        Animal.Flying.class, Default.class);
            } else {
                delegate.validate(target, errors);
            }*/
            delegate.validate(target, errors);
        }
    }
}
