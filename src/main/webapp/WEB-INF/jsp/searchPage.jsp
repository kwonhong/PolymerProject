<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<%@ include file="include/headerInclude.jsp" %>
</head>
<style>

	@font-face {
		font-family: RobotoBold;
		src: url(/resources/bower_components/Materialize/font/roboto/Roboto-Medium.woff);
	}

	.red_btn{
		background: red;
	}
	.red_btn:hover{
		opacity:0.7;
		transition: opacity 420ms ease-in-out;
	}
	.yellow_btn{
		background: yellow;
	}
	.orange_btn{
		background: orange;
	}
	.green_btn{
		background: green;
	}
	.blue_btn{
		background: blue;
	}
	.purple_btn{
		background: purple;
	}
	.teal_btn{
		background: teal;
	}

	paper-button{
		margin-right: 8px;
		margin-bottom: 8px;
		font-family: RobotoBold;
	}

	.logo{
		margin-bottom: 40px;
	}

	h1{
		font-family: RobotoBold;
		font-size: 20px;
	}

	.underLine {
		width: 100%;
		height: 3px;
		margin-top: 10px;
		margin-bottom: 10px;
		background-color: #ff526f;
	}

</style>
<body>

<nav-top></nav-top>

<div class="container">
	<div class="row">
		<div class="col-lg-8 col-lg-offset-2" align="center">
			<paper-card class ="logo" image="http://placehold.it/600x200"></paper-card>
		</div>
	</div>
</div>

<div class="container">
	<div class="row">
		<div class="col-lg-8 col-lg-offset-2" align="center">
			<search-bar class="searchbar"></search-bar>
		</div>
	</div>
</div>

<div class="container">
	<div class="row">
		<div class="col-lg-6 col-lg-offset-3" align="center">
			<ul>
				<paper-button raised class="red_btn" >test </paper-button>
				<paper-button raised class="yellow_btn" > testsdfsda </paper-button>
				<paper-button raised class="orange_btn" > testsdf </paper-button>
				<paper-button raised class="green_btn" > test </paper-button>
				<paper-button raised class="blue_btn" > test xdsf</paper-button>
				<paper-button raised class="teal_btn" > testsdf </paper-button>
				<paper-button raised class="purple_btn" > testsdfa </paper-button>
				<paper-button raised class="red_btn" > test </paper-button>
				<paper-button raised class="yellow_btn" > tessdaf </paper-button>
				<paper-button raised class="orange_btn" > testsdaf </paper-button>

			</ul>
		</div>
	</div>
</div>

<div class="container">
	<div class="col-lg-12">
		<h1> New Tutorial </h1>
		<c:forEach var="blog" items="${blogs}">
			<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="${blog.title}" blog-id="${blog.id}" id="cardOne"></image-card>
		</c:forEach>
		<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="testestsetsetes" blog-id="${blog.id}" id="cardOne"></image-card>
		<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="testestsetsetes" blog-id="${blog.id}" id="cardOne"></image-card>
		<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="testestsetsetes" blog-id="${blog.id}" id="cardOne"></image-card>
		<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="testestsetsetes" blog-id="${blog.id}" id="cardOne"></image-card>
		<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="testestsetsetes" blog-id="${blog.id}" id="cardOne"></image-card>
		<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="testestsetsetes" blog-id="${blog.id}" id="cardOne"></image-card>
		<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="testestsetsetes" blog-id="${blog.id}" id="cardOne"></image-card>
		<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="testestsetsetes" blog-id="${blog.id}" id="cardOne"></image-card>
		<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="testestsetsetes" blog-id="${blog.id}" id="cardOne"></image-card>
		<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="testestsetsetes" blog-id="${blog.id}" id="cardOne"></image-card>
		<image-card card-image="http://photoshopvip.net/wp-content/uploads/2015/11/space-final.jpg" card-text="testestsetsetes" blog-id="${blog.id}" id="cardOne"></image-card>
	</div>
</div>

<div class="underLine">&nbsp;</div>


<div class="row" >
		<search-pagination></search-pagination>
</div>
	</div>

</body>
</html>
