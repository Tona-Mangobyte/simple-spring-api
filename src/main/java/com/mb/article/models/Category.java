package com.mb.article.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="categories")
public class Category extends BaseEntity {

    @Column(name = "name")
    private String name;
}
