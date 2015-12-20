package com.tech.urls;


// Sadly this needs to be traditional constants as Enums cannot be used in Controller annotations.
public final class RequestMappingDefinitions {
    public static final String INDEX_URL_PATH = "/";
    public static final String BLOG_URL_PATH = "blog";
    public static final String SEARCH_RESULT_URL_PATH = "searchResultPage";
    public static final String AUTHOR_PROFILE_URL_PATH = "authorProfile";
    public static final String SEARCH_URL_PATH = "search";
    public static final String SEARCH_PAGE_URL_PATH = "searchPage";
    public static final String ABOUT_URL_PATH = "about";

    public static final String PREFIX_PAGE = "page-";

    public static String getViewName(String pathName) {
        return pathName.replace(".jsp", "").replace(".html", "");
    }
    public static String getAbsolutePath(String path) {
        return "/" + path;
    }
}
