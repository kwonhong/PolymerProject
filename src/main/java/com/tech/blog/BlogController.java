package com.tech.blog;

import com.tech.service.BlogService;
import com.tech.urls.RequestMappingDefinitions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = RequestMappingDefinitions.BLOG_URL_PATH + "/{blogID}", method = RequestMethod.GET)
    public String getBlog(
            @PathVariable Integer blogID,
            ModelMap model) {
//        List<Blog> blogList = blogService.findAllBlog();
        Blog blog = blogService.findBlogByID(blogID);

//        Blog blog = blogList.get(blogList.size() -1);
        model.addAttribute("blogComponents", blogService.getBlogComponents(blog.getContents()));
        model.addAttribute("blogTitle", blog.getTitle());
        model.addAttribute("blogAuthor", blog.getAuthor());
        model.addAttribute("blogDate", "15 Octoboer, 2015");
        return "blog";
    }
}
