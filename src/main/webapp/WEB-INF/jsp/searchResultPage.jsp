<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="include/headerInclude.jsp" %>
</head>
<body>

<nav-top></nav-top>
<!-- Page Content -->
<div class="container">

    <!-- Page Header -->
    <div class="row">
        <div class="col-lg-12">
            <search-resultTitle></search-resultTitle>
        </div>
    </div>
    <!-- /.row -->

    <!-- Projects Row -->
    <div class="row">
        <c:forEach var="blog" items="${blogs}">
            <div class="col s4">
                <search-resultItem blog-id="${blog.id}" blog-title="${blog.title}" blog-category="Java Code"></search-resultItem>
            </div>
        </c:forEach>
    </div>

</div>
<!-- /.row -->
<script type="text/javascript">
    $(".dropdown-button").dropdown();
</script>

</body>
</html>
