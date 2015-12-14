package com.tech.blog;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name="blog")
public class Blog implements Comparable<Blog>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="AUTHOR_ID", nullable = false)
    private int authorId;

    @Column(name ="CATEGORY_ID", nullable = false)
    private int categoryId;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "CONTENTS", nullable = true)
    private String contents;

    @Column(name = "VIEWS", nullable = true)
    private int views;

    @Column(name = "LIKES", nullable = true)
    private int likes;

    @Column(name = "CREATION_DATE", nullable = false)
    private Date createdDate;

    @Column(name = "UPDATED_DATE", nullable = false)
    private Date updatedDate;

    @Override
    public int compareTo(Blog o) {
        return this.createdDate.compareTo(o.getCreatedDate());
    }
}
