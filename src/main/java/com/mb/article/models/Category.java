package com.mb.article.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
