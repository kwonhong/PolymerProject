package com.tech.dao;

import com.tech.blog.Blog;

import java.util.List;

/**
 * Created by honkwon on 15-09-20.
 */
public interface BlogDao {

    void saveBlog(Blog blog);
    List<Blog> findAllBlog();
    List<Blog> findAllBlogWithQuery(String query, int limit, int offset);
    void deleteBlog(int blogID);
    Blog findBlogByID(int blogID);
    void updateBlog(Blog blog);
    void saveOrUpdateBlog(Blog blog);

    long countAllBlogWithQuery(String query);

    List<Blog> findMostRecentBlogs(int limit);

    List<Blog> findAllBlogByCategoryId(long categoryId, int limit, int offset);
}
