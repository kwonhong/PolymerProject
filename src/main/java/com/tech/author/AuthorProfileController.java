package com.tech.author;

import com.tech.service.AuthorService;
import com.tech.urls.RequestMappingDefinitions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorProfileController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = RequestMappingDefinitions.AUTHOR_PROFILE_URL_PATH + "/{authorID}", method = RequestMethod.GET)
    public String authorProfilePage(ModelMap modelMap,
                                    @PathVariable Integer authorID) {

        Author author = authorService.findAuthorByID(authorID);
        System.out.println(authorID);

        return "authorProfile";
    }
}
