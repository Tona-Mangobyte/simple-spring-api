package com.mb.article.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mb.article.common.UserRole;
import com.mb.article.common.UserRoleConverter;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @NotBlank(message = "username is required")
    @Column(name = "username")
    private String username;

    @JsonIgnore
    @NotBlank(message = "password is required")
    @Column(name = "password")
    private String password;

    @Convert(converter = UserRoleConverter.class)
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "role is required")
    @Column(name = "role", length = 20)
    private UserRole role;
}
