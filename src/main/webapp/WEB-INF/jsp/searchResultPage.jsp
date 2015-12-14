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


<!-- Page Content -->
<div class="container">

    <%-- Search Result Title --%>
    <div class="row">
        <div class="col-lg-12">
            <search-resultTitle search-result-text="${searchText}" search-result-num="${searchNum}"></search-resultTitle>
        </div>
    </div>
    <%-- End Search Result Title --%>


    <div class="row">

        <%-- Search Result Blogs/Tutorials --%>
        <div class="col-lg-8">
            <c:forEach var="blog" items="${blogs}">
                <div class="col-lg-4">
                    <c:set var="category" value="${categoryService.getCategoryById(blog.categoryId)}"/>
                    <search-resultItem blog-id="${blog.id}"
                                       blog-title="${blog.title}"
                                       blog-category-name="${category.displayName}"
                                       blog-category-color="${category.color}">

                    </search-resultItem>
                </div>
            </c:forEach>
        </div>
        <%-- End Search Result Blogs/Tutorials --%>

        <%-- Latest Blog Components--%>
        <div class="col-lg-4">
            <aside class="blog aside section">
                <div class="section-inner">
                    <h2 class="heading">Latest Blog Posts</h2>
                    <div class="underLine">&nbsp;</div>
                </div>

                <div id="rss-feeds" class="content">
                    <c:forEach var="blog" items="${mostRecentBlogs}">
                        <blog-related-item blog-id="${blog.id}" blog-title="${blog.title}" blog-description="${blog.description}"></blog-related-item>
                    </c:forEach>
                </div>
            </aside>
        </div>
        <%-- End Latest Blog Components--%>

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
