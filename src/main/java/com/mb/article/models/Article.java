package com.mb.article.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="articles")
public class Article extends BaseEntity {
    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "content")
    private String content;

}
