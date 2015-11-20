package com.tech.dao;

import com.tech.author.Author;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthoDaoImpl extends AbstractDao implements AuthorDao {

    @Override
    public void saveAuthor(Author author) {
        persist(author);
    }

    @Override
    public List<Author> findAllAuthors() {
        Criteria criteria = getSession().createCriteria(Author.class);
        return criteria.list();
    }

    @Override
    public void deleteAuthor(int authorID) {
        Query query = getSession().createSQLQuery("delete from Author where id = :id");
        query.setInteger("id", authorID);
        query.executeUpdate();
    }

    @Override
    public Author findAuthorByID(int authorID) {
        Criteria criteria = getSession().createCriteria(Author.class);
        criteria.add(Restrictions.eq("id", authorID));
        return (Author) criteria.uniqueResult();
    }

    @Override
    public void updateAuthor(Author author) {
        getSession().update(author);
    }

    @Override
    public void saveOrUpdateAuthor(Author author) {
        getSession().saveOrUpdate(author);
    }
}
