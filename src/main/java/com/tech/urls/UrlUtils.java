package com.tech.urls;

import com.sun.jersey.api.uri.UriBuilderImpl;

import java.net.URI;

public class UrlUtils {
    public static String setParameter(String url, String name, String value) {
        return new UriBuilderImpl()
                .uri(URI.create(url))
                .replaceQueryParam(name, value)
                .build()
                .toString();
    }
}
