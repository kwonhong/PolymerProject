<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="include/headerInclude.jsp" %>
</head>
<body>
<style>
    .container {
        /*margin-top: 50px;*/
        /*margin-left: 100px;*/
        /*margin-bottom: 50px;*/
        /*margin-right: 50px;*/
        /*padding: 20px;*/
    }

</style>
<nav-top></nav-top>

<div class="container">
    <div class="row">
        <div class="col s8">
            <blog-title title-text="${blogTitle}" author-name="${blogAuthor.displayName}" date="${blogDate}"></blog-title>
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
        <div class="col s3 offset-s1">
            <blog-author author-display-name="${blogAuthor.displayName}"></blog-author>

        </div>
    </div>
</div>

</body>

<script type="text/javascript">
    $(".dropdown-button").dropdown();
</script>
</html>
