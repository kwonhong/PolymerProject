package com.tech.dao;

import com.tech.category.Category;
import org.hibernate.Criteria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryDaoImpl extends AbstractDao implements CategoryDao {

    @Override
    public List<Category> getAllCategories() {
        Criteria criteria = getSession().createCriteria(Category.class);
        return (List<Category>) criteria.list();
    }
}
