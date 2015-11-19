package com.tech.urls;


// Sadly this needs to be traditional constants as Enums cannot be used in Controller annotations.
public final class RequestMappingDefinitions {
    public static final String INDEX_URL_PATH = "/";
    public static final String BLOG_URL_PATH = "blog";
    public static final String SEARCH_URL_PATH = "searchResultPage";

    public static String getViewName(String pathName) {
        return pathName.replace(".jsp", "").replace(".html", "");
    }
}
