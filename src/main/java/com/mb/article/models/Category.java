package com.mb.article.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name="categories")
public class Category extends BaseEntity {

    @NotBlank(message = "Name is required")
    @Column(name = "name")
    private String name;
}
