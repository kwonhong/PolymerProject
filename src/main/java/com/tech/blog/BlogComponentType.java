package com.tech.blog;

import lombok.Getter;

/**
 * Created by honkwon on 15-11-15.
 */
public enum BlogComponentType {

    BLOG_HEADER("#header"),
    BLOG_PARAGRAPH("#para"),
    BLOG_VIDEO("#video"),
    BLOG_CODE("#code"),
    BLOG_IMAGE("#image"),
    BLOG_END_DELIMITER("##");

    @Getter private String delimiter;
    BlogComponentType(String delimiter) {
        this.delimiter = delimiter;
    }
}
