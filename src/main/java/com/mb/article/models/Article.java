package com.mb.article.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name="articles")
public class Article extends BaseEntity {
    @NotBlank(message = "Title is required")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "Content is required")
    @Lob
    @Column(name = "content")
    private String content;

}
