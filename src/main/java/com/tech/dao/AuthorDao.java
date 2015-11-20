package com.tech.dao;

import com.tech.author.Author;

import java.util.List;

/**
 * Created by honkwon on 15-11-19.
 */
public interface AuthorDao {
    void saveAuthor(Author author);
    List<Author> findAllAuthors();
    void deleteAuthor(int authorID);
    Author findAuthorByID(int authorID);
    void updateAuthor(Author author);
    void saveOrUpdateAuthor(Author author);
}
