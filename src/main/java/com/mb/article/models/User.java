package com.mb.article.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mb.article.common.UserRole;
import com.mb.article.common.UserRoleConverter;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "username")
    private String username;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Convert(converter = UserRoleConverter.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 20)
    private UserRole role;
}
