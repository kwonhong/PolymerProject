<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<style>
	li{
		margin-right: 8px;
		margin-bottom: 8px;
	}
	.blog-button{
		margin-right: 8px;
		margin-bottom: 8px;
	}

	.logo{
		margin-top: 30px;
	}
</style>


<head>
	<%@ include file="include/headerInclude.jsp" %>
</head>
<body>

<nav-top></nav-top>


<div class="container" >
	<div class="row">
		<div class="col s8 offset-s2" align="center">
			<paper-card class ="logo" image="http://placehold.it/600x200"></paper-card>
		</div>
	</div>
</div>

<div class="row">
	<search-bar></search-bar>
</div>

<div class="container">
	<div class="row">
		<div class="col s8 offset-s2" align="center">
			<ul>
				<blog-button button-text="tedddt" background-colour="#2bbbad" ></blog-button>
				<li class="teal waves-effect waves-light btn">one</li>
				<li class="blue waves-effect waves-light btn">two</li>
				<li class="orange waves-effect waves-light btn">three</li>
				<li class="red waves-effect waves-light btn">three</li>
				<li class="green waves-effect waves-light btn">three</li>
				<li class="purple waves-effect waves-light btn">three</li>
				<li class="pink waves-effect waves-light btn">three</li>
				<li class="brown waves-effect waves-light btn">three</li>
				<li class="black waves-effect waves-light btn">three</li>
			</ul>
		</div>
	</div>
</div>

<div class="row">
	<div class="col s10 offset-s1">
		<paper-card heading="New Tutorial">
			<c:forEach var="blog" items="${blogs}">
					<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="${blog.title}" blog-id="${blog.id}" id="cardOne"></image-card>
			</c:forEach>
			<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="${blog.title}" blog-id="${blog.id}" id="cardOne"></image-card>
			<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="${blog.title}" blog-id="${blog.id}" id="cardOne"></image-card>
			<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="${blog.title}" blog-id="${blog.id}" id="cardOne"></image-card>
			<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="${blog.title}" blog-id="${blog.id}" id="cardOne"></image-card>
			<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="${blog.title}" blog-id="${blog.id}" id="cardOne"></image-card>
			<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="${blog.title}" blog-id="${blog.id}" id="cardOne"></image-card>
			<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="${blog.title}" blog-id="${blog.id}" id="cardOne"></image-card>
			<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="${blog.title}" blog-id="${blog.id}" id="cardOne"></image-card>
			<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="${blog.title}" blog-id="${blog.id}" id="cardOne"></image-card>
			<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="${blog.title}" blog-id="${blog.id}" id="cardOne"></image-card>
			<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="${blog.title}" blog-id="${blog.id}" id="cardOne"></image-card>

		</paper-card>
	</div>
</div>

<div class="row">
	<div class="col s10 offset-s1" align="center">
		<search-pagination></search-pagination>
	</div>
</div>


</body>

<script type="text/javascript">
	$(".dropdown-button").dropdown();
</script>
</html>
