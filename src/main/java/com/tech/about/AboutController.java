package com.tech.about;

import com.tech.urls.RequestMappingDefinitions;
import com.tech.urls.UrlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AboutController {

    @Autowired
    private UrlHelper urlHelper;

    @RequestMapping(value = RequestMappingDefinitions.ABOUT_URL_PATH, method = RequestMethod.GET)
    public String getAboutPage(ModelMap modelMap) {
        modelMap.addAttribute("urlHelper", urlHelper);

        return RequestMappingDefinitions.ABOUT_URL_PATH;
    }
}
