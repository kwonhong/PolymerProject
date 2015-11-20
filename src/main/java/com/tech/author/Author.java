package com.tech.author;

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
@Table(name="Author")
public class Author{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "DISPLAY_NAME", nullable = false)
    private String displayName;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "CREATION_DATE", nullable = false)
    private Date createdDate;

    @Column(name = "UPDATED_DATE", nullable = false)
    private Date updatedDate;

}
