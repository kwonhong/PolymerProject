package com.tech.urls;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.tech.urls.RequestMappingDefinitions.*;

/**
 * Created by honkwon on 15-09-23.
 */

@Component("urlHelper")
@Scope("singleton")
public final class UrlHelper {

    public String URL_HELPER_ATTRIBUTE_NAME = "urlHelper";

    public String getBlogUrlPath() {
        return BLOG_URL_PATH;
    }

    public String getSearchUrlPath() {
        return SEARCH_URL_PATH;
    }

    public String getSearchPageUrlPath() {
        return SEARCH_PAGE_URL_PATH;
    }

    public String getIndexUrlPath() {
        return INDEX_URL_PATH;
    }

    public String getSearchUrlWithPagination(int pageNum, String searchText) {
        return UrlUtils.setParameter("/" + SEARCH_URL_PATH + "/" + PREFIX_PAGE + pageNum + "/", "searchText",  searchText);
    }

    public String getAboutUrlPath() {
        return getAbsolutePath(ABOUT_URL_PATH);
    }

    public String getAuthorUrl(int authorId) {
        return getAbsolutePath(AUTHOR_PROFILE_URL_PATH + "/" + authorId);
    }
}
