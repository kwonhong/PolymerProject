package com.tech.search;


import com.tech.blog.Blog;
import com.tech.service.BlogService;
import com.tech.urls.RequestMappingDefinitions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = RequestMappingDefinitions.SEARCH_URL_PATH, method = RequestMethod.GET)
    public String getSearchResult(ModelMap model) {

        List<Blog> blogs = blogService.findAllBlogWithQuery("");
        model.addAttribute("blogs", blogs);

        return "searchResultPage";
    }
}
