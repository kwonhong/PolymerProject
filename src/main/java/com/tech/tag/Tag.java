package com.tech.tag;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by honkwon on 15-11-19.
 */

@Data
@Entity
@Table(name = "Tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "BLOG_ID", nullable = false)
    private int blogId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DISPLAY_NAME", nullable = false)
    private String displayName;

    @Column(name = "CREATION_DATE", nullable = false)
    private Date createdDate;

    @Column(name = "UPDATED_DATE", nullable = false)
    private Date updatedDate;

}
