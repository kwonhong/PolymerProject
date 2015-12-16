package com.tech.service;

import com.google.common.base.Preconditions;
import com.tech.blog.Blog;
import com.tech.blog.BlogComponent;
import com.tech.blog.BlogComponentType;
import com.tech.dao.BlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.tech.blog.BlogComponentType.BLOG_END_DELIMITER;

/**
 * Created by honkwon on 15-09-20.
 */
@Service("blogService")
@Component
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao dao;

    @Override
    public void saveBlog(Blog blog) {
        dao.saveBlog(blog);
    }

    @Override
    public List<Blog> findAllBlog() {
        return dao.findAllBlog();
    }

    @Override
    public void deleteBlogByID(int id) {
        dao.deleteBlog(id);
    }

    @Override
    public Blog findBlogByID(int id) {
        return dao.findBlogByID(id);
    }

    @Override
    public List<Blog> findAllBlogWithQuery(String query, int limit, int offset) {
        return dao.findAllBlogWithQuery(query, limit, offset);
    }

    @Override
    public List<Blog> findMostRecentBlogs(int limit) {
        return dao.findMostRecentBlogs(limit);
    }

    @Override
    public List<Blog> findAllBlogByCategoryId(long categoryId, int limit, int offset) {
        return dao.findAllBlogByCategoryId(categoryId, limit, offset);
    }

    @Override
    public long countAllBlogWithQuery(String query) {
        return dao.countAllBlogWithQuery(query);
    }

    @Override
    public void updateBlog(Blog blog){
        dao.updateBlog(blog);
    }

    @Override
    public void saveOrUpdate(Blog blog) {
        dao.saveOrUpdateBlog(blog);
    }

    @Override
    public List<BlogComponent> getBlogComponents(String content) {
        if (!StringUtils.hasText(content)) {
            return Collections.emptyList();
        }

        List<BlogComponent> blogComponents = new ArrayList<>();
        while (StringUtils.hasText(content.trim())) {
            BlogComponentType blogComponentType = findNextComponentType(content);
            BlogComponent blogComponent = getNextBlogComponent(content, blogComponentType);
            if (blogComponent != null) {
                blogComponents.add(blogComponent);
            }

            content = updateContent(content);
        }

        return blogComponents;
    }

    private String updateContent(String content) {
        String endDelimiter = BLOG_END_DELIMITER.getDelimiter();
        int endIndex = content.indexOf(endDelimiter);

        return content.substring(endIndex + endDelimiter.length());
    }

    private BlogComponent getNextBlogComponent(String content, BlogComponentType blogComponentType) {
        // Argument Checking
        if (!StringUtils.hasText(content) || blogComponentType == null) {
            return null;
        }

        int startIndex = content.indexOf(blogComponentType.getDelimiter());
        int endIndex = content.indexOf(BLOG_END_DELIMITER.getDelimiter(), startIndex);
        return (startIndex > endIndex || startIndex == -1 || endIndex == -1) ?
                null :
                new BlogComponent(
                        blogComponentType,
                        content.substring(startIndex + blogComponentType.getDelimiter().length(), endIndex));
    }

    private BlogComponentType findNextComponentType(String content) {
        Preconditions.checkArgument(StringUtils.hasText(content)); // Checking condition

        BlogComponentType blogComponentType = null;
        int smallestIndex = Integer.MAX_VALUE;

        // Looping through the find the first component.
        for (BlogComponentType blogComponent: BlogComponentType.values()) {
            int startIndex = content.indexOf(blogComponent.getDelimiter());
            if (smallestIndex > startIndex && startIndex != -1) {
                blogComponentType = blogComponent;
                smallestIndex = startIndex;
            }
        }

        return blogComponentType;
    }


}
