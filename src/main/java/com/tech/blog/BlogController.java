package com.tech.blog;

import com.tech.service.AuthorService;
import com.tech.service.BlogService;
import com.tech.service.CategoryService;
import com.tech.urls.RequestMappingDefinitions;
import com.tech.urls.UrlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogController {

    private static final int RELATED_SEARCH_LIMIT = 3;
    private static final int RELATED_SEARCH_OFFSET = 0;

    @Autowired
    private BlogService blogService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UrlHelper urlHelper;

    @RequestMapping(value = RequestMappingDefinitions.BLOG_URL_PATH + "/{blogID}", method = RequestMethod.GET)
    public String getBlog(
            @PathVariable Integer blogID,
            ModelMap model) {

        Blog blog = blogService.findBlogByID(blogID);
        model.addAttribute("blog", blog);
        model.addAttribute("blogComponents", blogService.getBlogComponents(blog.getContents()));
        model.addAttribute("blogAuthor", authorService.findAuthorByID(blog.getAuthorId()));
        model.addAttribute("blogCategory", categoryService.getCategoryById(blog.getCategoryId()));
        model.addAttribute("relatedBlogs" ,blogService.findAllBlogByCategoryId(blog.getCategoryId(), RELATED_SEARCH_LIMIT, RELATED_SEARCH_OFFSET));
        model.addAttribute("urlHelper", urlHelper);

        return "blog";
    }
}
