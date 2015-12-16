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
                    <a class="nav-link page-scroll" href="#">Tutorials</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link page-scroll" href="#">About Us</a>
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
                <blog-author author-display-name="${blogAuthor.displayName}" category-color="${blogCategory.color}"
                             author-link="${urlHelper.getAuthorUrl(blogAuthor.id)}"></blog-author>
            </div>
            <div class="row">
                <div class="section" style="background-color: ${blogCategory.color}">
                    <div class="section-inner">
                        <h2 class="heading">Related Blog Posts</h2>
                        <div class="underLine">&nbsp;</div>
                    </div>
                    <div id="rss-feeds" class="content">
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
