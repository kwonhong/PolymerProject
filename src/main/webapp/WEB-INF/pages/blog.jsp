<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="utf-8">

  <!-- List of dependencies! -->
  <script src="resources/bower_components/webcomponentsjs/webcomponents.js"></script>

  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

  <!-- Compiled and minified JavaScript -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/js/materialize.min.js"></script>

  <link href="resources/bower_components/Materialize/sass/materialize.css" rel="stylesheet">


  <link href="resources/elements/navElements/nav-top.html" rel="import">
  <link href="resources/elements/blogElements/blog-paragraph.html" rel="import">
  <link href="resources/elements/blogElements/blog-title.html" rel="import">
  <link href="resources/elements/blogElements/blog-video.html" rel="import">
  <link href="resources/elements/blogElements/blog-header.html" rel="import">
  <link href="resources/elements/blogElements/blog-code.html" rel="import">
</head>
<body>
<nav-top></nav-top>

<div class="container">
  <div class="row">
    <div class="col s8">

      <blog-title title-text="${blogTitle}" author-name="${blogAuthor}" date="${blogDate}"></blog-title>
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
  </div>

</body>

<script type="text/javascript">
  $(".dropdown-button").dropdown();
</script>
</html>
