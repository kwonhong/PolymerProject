package com.tech.blog;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class BlogComponent {

    private BlogComponentType blogComponentType;
    private String content;
}
