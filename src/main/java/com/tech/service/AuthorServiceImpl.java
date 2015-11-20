package com.tech.service;

import com.tech.author.Author;
import com.tech.dao.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("authorService")
@Component
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author findAuthorByID(int id) {
        return authorDao.findAuthorByID(id);
    }
}
