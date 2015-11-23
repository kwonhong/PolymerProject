package com.tech.urls;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by honkwon on 15-09-23.
 */

@Component("urlHelper")
@Scope("singleton")
public final class UrlHelper {

    public static final String URL_HELPER_ATTRIBUTE_NAME = "urlHelper";
    public static final String getBlogUrlPath() {
        return RequestMappingDefinitions.BLOG_URL_PATH;
    }
    public static final String getSearchUrlPath() {
        return RequestMappingDefinitions.SEARCH_URL_PATH;
    }
    public static final String getSearchPageUrlPath() {
        return RequestMappingDefinitions.SEARCH_PAGE_URL_PATH;
    }
    public static final String getIndexUrlPath() {
        return RequestMappingDefinitions.INDEX_URL_PATH;
    }
}
