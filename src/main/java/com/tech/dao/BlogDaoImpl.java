package com.tech.dao;

import com.tech.blog.Blog;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by honkwon on 15-09-20.
 */

@Component
public class BlogDaoImpl extends AbstractDao implements BlogDao{

    @Override
    public void saveBlog(Blog blog) {
        persist(blog);
    }

    @Override
    public List<Blog> findAllBlog() {
        Criteria criteria = getSession().createCriteria(Blog.class);
        return (List<Blog>) criteria.list();
    }

    //TODO Change to StringBuilder
    @Override
    public List<Blog> findAllBlogWithQuery(String query, int limit, int offset) {
        String sqlQuery = "SELECT * from blog where blog.title LIKE \'%" + query + "%\' LIMIT " + limit + " OFFSET " + offset;
        return getSession().createSQLQuery(sqlQuery).addEntity(Blog.class).list();
    }

    @Override
    public void deleteBlog(int blogID) {
        Query query = getSession().createSQLQuery("delete from Blog where id = :id");
        query.setInteger("id", blogID);
        query.executeUpdate();
    }

    @Override
    public Blog findBlogByID(int blogID) {
        Criteria criteria = getSession().createCriteria(Blog.class);
        criteria.add(Restrictions.eq("id", blogID));
        return (Blog) criteria.uniqueResult();
    }

    @Override
    public void updateBlog(Blog blog) {
        getSession().update(blog);
    }

    @Override
    public void saveOrUpdateBlog(Blog blog) {
        getSession().saveOrUpdate(blog);
    }

    @Override
    public long countAllBlogWithQuery(String query) {
        String sqlQuery = "SELECT count(*) from blog where blog.title LIKE \'%" + query + "%\'";
        return  ((BigInteger) getSession().createSQLQuery(sqlQuery).list().get(0)).longValue(); //TODO Find a better way to do this
    }

    @Override
    public List<Blog> findMostRecentBlogs(int limit) {
        String sqlQuery = "SELECT * from blog ORDER BY CREATION_DATE DESC LIMIT " + limit;
        return getSession().createSQLQuery(sqlQuery).addEntity(Blog.class).list();
    }

    @Override
    public List<Blog> findAllBlogByCategoryId(long categoryId, int limit, int offset) {
        String sqlQuery = "SELECT * from blog WHERE CATEGORY_ID = " + categoryId + " LIMIT " + limit + " OFFSET " + offset;
        return getSession().createSQLQuery(sqlQuery).addEntity(Blog.class).list();
    }
}
