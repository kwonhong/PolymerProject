package com.tech.search;


import com.tech.blog.Blog;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {

    private static final int BLOG_NUM_PER_PAGE = 9;

    @Autowired
    private BlogService blogService;

    @Autowired
    private UrlHelper urlHelper;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = RequestMappingDefinitions.SEARCH_URL_PATH, method = RequestMethod.GET)
    public String getSearchResult(ModelMap model,
                                  @RequestParam("searchText") String searchText) {

        // Search Result with default pager
        Pager pager = new Pager();
        getSearchResultHelper(model, pager, searchText);

        return RequestMappingDefinitions.SEARCH_RESULT_URL_PATH;
    }

    @RequestMapping(value = RequestMappingDefinitions.SEARCH_URL_PATH + "/" + RequestMappingDefinitions.PREFIX_PAGE + "{pageNum}", method = RequestMethod.GET)
    public String getSearchResultWithPagination(ModelMap modelMap,
                                                @PathVariable Integer pageNum,
                                                @RequestParam String searchText) {

        // TODO Validate if the page number is valid!
        if (pageNum <= 0) {
            pageNum = 1;
        }

        Pager pager = new Pager(pageNum);
        getSearchResultHelper(modelMap, pager, searchText);

        return RequestMappingDefinitions.SEARCH_RESULT_URL_PATH;
    }

    private void getSearchResultHelper(ModelMap modelMap, Pager pager, String searchText) {

        long count = blogService.countAllBlogWithQuery(searchText);
        List<Blog> blogs = blogService.findAllBlogWithQuery(searchText, Pager.DEFAULT_SEARCH_RESULT_SIZE, pager.getOffset());
        List<Blog> mostRecentBlogs = blogService.findMostRecentBlogs(Pager.DEFAULT_LATEST_BLOG_NUM);

        modelMap.addAttribute("blogs", blogs);
        modelMap.addAttribute("mostRecentBlogs", mostRecentBlogs);
        modelMap.addAttribute("searchText", searchText);
        modelMap.addAttribute("searchNum", blogs.size());
        modelMap.addAttribute("categoryService", categoryService);
        modelMap.addAttribute("urlHelper", urlHelper);

        modelMap.addAttribute("paginationNums", pager.getPaginationNumbers(blogs.size()));
        modelMap.addAttribute("activePageNum", pager.getPageNum());
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
