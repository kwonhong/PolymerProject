package com.tech.blog;

import com.tech.service.BlogServiceImpl;

import java.util.List;

/**
 * Created by honkwon on 15-11-15.
 */
public class BlogServiceImplTest {

    public void blogServiceComponentParsingTest() {
        BlogServiceImpl blogService = new BlogServiceImpl();
        List<BlogComponent> blogComponentList =
                blogService.getBlogComponents("#header this is header ## \n#para this is paragraph ##");
    }

    public static void main(String[] args) {
        BlogServiceImplTest blogServiceImplTest = new BlogServiceImplTest();
        blogServiceImplTest.blogServiceComponentParsingTest();
}
}
