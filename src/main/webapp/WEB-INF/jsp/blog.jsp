<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="include/headerInclude.jsp" %>
</head>
<body>

<!-- Top Navigation Parts -->
<nav id="topNav" class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <button class="navbar-toggler hidden-md-up pull-right" type="button" data-toggle="collapse"
                data-target="#collapsingNavbar"> ☰
        </button>
        <a class="navbar-brand page-scroll" href="#first">TTBlog</a>

        <div class="collapse navbar-toggleable-sm" id="collapsingNavbar">
            <ul class="nav navbar-nav">
                <li class="nav-item">
                    <a class="nav-link page-scroll" href="${urlHelper.getSearchPageUrlPath()}">Tutorials</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link page-scroll" href="${urlHelper.getAboutUrlPath()}">About Us</a>
                </li>
            </ul>
            <ul class="nav navbar-nav pull-right">
                <li class="nav-item">
                    <a class="control nav-link page-scroll" href="#">
                        <i class='control icon-search ion-search'></i>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class='searchBox'></div>
<i class='icon-close ion-ios-close-empty'></i>

<form class="navbar-form navbar-right" role="search" action="/search">
    <div class='form'>
        <input name="searchText" type="text" class="input-search" placeholder="Search Tutorial" autocomplete="off">
    </div>
</form>
<%-----------------------------%>
<!-- End Top Navigation Parts -->

<div class="container">
    <div class="row">
        <div class="col-lg-7">
            <%--<blog-title title-text="${blog.title}" author-name="${blogAuthor.displayName}" date="${blog.createdDate}"--%>
                <%--category-color="${blogCategory.color}"></blog-title>--%>
            <blog-title title-text="${blog.title}" author-name="${blogAuthor.displayName}" category-color="${blogCategory.color}"></blog-title>
            <c:forEach var="blogComponent" items="${blogComponents}">
                <c:choose>
                    <c:when test="${blogComponent.blogComponentType=='BLOG_HEADER'}">
                        <blog-header header-text="${blogComponent.content}"></blog-header>
                    </c:when>

                    <c:when test="${blogComponent.blogComponentType=='BLOG_PARAGRAPH'}">
                        <blog-paragraph paragraph-text="${blogComponent.content}"></blog-paragraph>
                    </c:when>

                    <c:when test="${blogComponent.blogComponentType=='BLOG_VIDEO'}">
                        <blog-video></blog-video>
                    </c:when>

                    <c:when test="${blogComponent.blogComponentType=='BLOG_CODE'}">
                        <blog-code code-text="p { color: red }" code-type="language-css"></blog-code>
                    </c:when>

                    <c:when test="${blogComponent.blogComponentType=='BLOG_IMAGE'}">
                        <img class="img-responsive" src="${blogComponent.content}" alt="">
                    </c:when>

                    <c:when test="${blogComponent.blogComponentType=='BLOG_END_DELIMITER'}">
                        <span class="caption text-muted"> ${blogComponent.content} </span>
                    </c:when>

                    <c:otherwise>
                        Something else has been detected.
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>

        <div class="col-lg-offset-1 col-lg-4">
            <div class="row">
                <div class="section" style="background-color: ${blogCategory.color}">
                    <div class="section-inner">
                        <h2 class="heading">Author Description</h2>
                        <div class="underLine">&nbsp;</div>
                    </div>

                    <div class="content" style="border-color: ${blogCategory.color}">
                        <div class="media">
                            <div class="media-left">
                                <a href="${urlHelper.getAuthorUrlPath(blogAuthor.id)}">
                                    <img class="media-object border"
                                         src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIHZpZXdCb3g9IjAgMCA2NCA2NCIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+PCEtLQpTb3VyY2UgVVJMOiBob2xkZXIuanMvNjR4NjQKQ3JlYXRlZCB3aXRoIEhvbGRlci5qcyAyLjYuMC4KTGVhcm4gbW9yZSBhdCBodHRwOi8vaG9sZGVyanMuY29tCihjKSAyMDEyLTIwMTUgSXZhbiBNYWxvcGluc2t5IC0gaHR0cDovL2ltc2t5LmNvCi0tPjxkZWZzPjxzdHlsZSB0eXBlPSJ0ZXh0L2NzcyI+PCFbQ0RBVEFbI2hvbGRlcl8xNTEyYzA1ZDUzOCB0ZXh0IHsgZmlsbDojQUFBQUFBO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1mYW1pbHk6QXJpYWwsIEhlbHZldGljYSwgT3BlbiBTYW5zLCBzYW5zLXNlcmlmLCBtb25vc3BhY2U7Zm9udC1zaXplOjEwcHQgfSBdXT48L3N0eWxlPjwvZGVmcz48ZyBpZD0iaG9sZGVyXzE1MTJjMDVkNTM4Ij48cmVjdCB3aWR0aD0iNjQiIGhlaWdodD0iNjQiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSIxMy40Njg3NSIgeT0iMzYuNSI+NjR4NjQ8L3RleHQ+PC9nPjwvZz48L3N2Zz4="
                                         alt="...">
                                </a>
                            </div>
                            <div class="media-body">
                                <a href="${urlHelper.getAuthorUrlPath(blogAuthor.id)}" ><h5 class="media-heading authorName" style="color: ${blogCategory.color}">${blogAuthor.displayName}</h5></a>
                                <p class="authorPosition"> Software Engineering Developer</p>
                                <p class="authorDescription">I'm a youtuber/journalist/filmmaker and most importantly a positive
                                    thinker. I love making videos, taking photos and editing it all.
                                    I may be a diva fashionista, but deep in my heart I'm the biggest nerd. I love elephants and
                                    reading! </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="section" style="background-color: ${blogCategory.color}">
                    <div class="section-inner">
                        <h2 class="heading">Related Blog Posts</h2>
                        <div class="underLine">&nbsp;</div>
                    </div>
                    <div class="content" style="border-color: ${blogCategory.color}">
                        <c:forEach var="blog" items="${relatedBlogs}" varStatus="loop">
                            <blog-related-item blog-id="${blog.id}" blog-title="${blog.title}" blog-description="${blog.description}"></blog-related-item>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

</body>

<%-- Navigation Search Bar Javascript--%>
<script type="text/javascript">
    $('.control').click(function () {
        $('body').addClass('mode-search');
        $('.input-search').focus();
    });

    $('.icon-close').click(function () {
        $('body').removeClass('mode-search');
    });

    $('.input-search').keypress(function (e) {
        var key = e.which;
        if (key == 13) {
            $('body').removeClass('mode-search');
        }
    });
</script>
<%-- End Navigation Search Bar Javascript--%>
</html>
