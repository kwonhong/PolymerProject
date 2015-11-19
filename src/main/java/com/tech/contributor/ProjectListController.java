package com.tech.contributor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectListController {

    @RequestMapping(value = "/projectList", method = RequestMethod.GET)
    public String getProjectList() {


        return "projectList";
    }
}
