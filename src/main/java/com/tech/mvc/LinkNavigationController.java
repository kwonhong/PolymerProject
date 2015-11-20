package com.tech.mvc;

import com.tech.blog.Blog;
import com.tech.service.BlogService;
import com.tech.urls.RequestMappingDefinitions;
import com.tech.urls.UrlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LinkNavigationController {

    private static final int MAX_LENGTH = 50;

    @Autowired
    private UrlHelper urlHelper;

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = RequestMappingDefinitions.INDEX_URL_PATH, method = RequestMethod.GET)
    public String getIndexResult(ModelMap model) {



        List<Blog> blogs = blogService.findAllBlog();
        blogs.stream().forEach(blogService -> {

            String title = blogService.getTitle();
            title = (title.length() > MAX_LENGTH)? title.substring(0, 50) : title;
            blogService.setTitle(title);
        });

        model.addAttribute("blogs", blogs);

        return "hello";
    }

    public ModelAndView getDefaultModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("urlHelper", urlHelper);
        return modelAndView;
    }

}
