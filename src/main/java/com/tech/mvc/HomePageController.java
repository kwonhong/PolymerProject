package com.tech.mvc;

import com.tech.urls.UrlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {

    @Autowired
    private UrlHelper urlHelper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView indexPage() {
        ModelAndView modelAndView = getDefaultModelAndView();
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    public ModelAndView getDefaultModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("urlHelper", urlHelper);
        return modelAndView;
    }

}
