package com.tech.search;


import com.tech.blog.Blog;
import com.tech.service.BlogService;
import com.tech.urls.RequestMappingDefinitions;
import com.tech.urls.UrlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UrlHelper urlHelper;

    @RequestMapping(value = RequestMappingDefinitions.SEARCH_URL_PATH, method = RequestMethod.GET)
    public String getSearchResult(ModelMap model,
                                  @RequestParam("searchText") String searchText) {

        List<Blog> blogs = blogService.findAllBlogWithQuery(searchText);
        model.addAttribute("blogs", blogs);

        return RequestMappingDefinitions.SEARCH_RESULT_URL_PATH;
    }

    @RequestMapping(value = RequestMappingDefinitions.SEARCH_PAGE_URL_PATH, method = RequestMethod.GET)
    public String defaultSearchPage(ModelMap modelMap) {

        List<Blog> recentBlogs = blogService.findAllBlog();
        modelMap.addAttribute("blogs", recentBlogs);
        return RequestMappingDefinitions.SEARCH_PAGE_URL_PATH;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView indexPage() {
        ModelAndView modelAndView = getDefaultModelAndView();
        modelAndView.setViewName("searchPage");
        return modelAndView;
    }

    public ModelAndView getDefaultModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("urlHelper", urlHelper);
        return modelAndView;
    }
}
