package com.mb.article.common;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UserRoleConverter implements AttributeConverter<UserRole, String> {
    @Override
    public String convertToDatabaseColumn(UserRole role) {
        return role.getRole();
    }

    @Override
    public UserRole convertToEntityAttribute(String dbData) {
        for (UserRole role : UserRole.values()) {
            if (role.getRole().equals(dbData)) {
                return role;
            }
        }

        throw new IllegalArgumentException("Unknown database value:" + dbData);
    }
}
