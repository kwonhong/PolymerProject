package com.tech.service;

import com.tech.blog.Blog;
import com.tech.blog.BlogComponent;

import java.util.List;

/**
 * Created by honkwon on 15-09-20.
 */
public interface BlogService {

    void saveBlog(Blog blog);

    List<Blog> findAllBlog();

    List<Blog> findAllBlogWithQuery(String query, int limit, int offset);

    List<Blog> findMostRecentBlogs(int limit);

    long countAllBlogWithQuery(String query);

    void deleteBlogByID(int id);

    Blog findBlogByID(int id);

    void updateBlog(Blog blog);

    void saveOrUpdate(Blog blog);

    List<BlogComponent> getBlogComponents(String contents);
}
