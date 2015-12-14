package com.tech.service;

import com.tech.category.Category;
import com.tech.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Singleton;
import java.util.List;

@Service("categoryService")
@Singleton
@Component
@Transactional
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    private List<Category> categoryList;

    public Category getCategoryById(int id) {
        if (categoryList == null)
            populateCategories();

        // Database index starts from 1
        return categoryList.get(id - 1);
    }

    private void populateCategories() {
        this.categoryList = categoryDao.getAllCategories();
    }


}
