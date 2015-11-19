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
@Table(name="BLOG")
public class Blog implements Comparable<Blog>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "AUTHOR", nullable = false)
    private String author;

    @Column(name = "CONTENTS", nullable = true)
    private String contents;

    @Column(name = "CREATION_DATE", nullable = false)
    private Date createdDate;

    @Override
    public int compareTo(Blog o) {
        return this.createdDate.compareTo(o.getCreatedDate());
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", contents='" + contents + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
