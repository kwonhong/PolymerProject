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


<style>
    .centered {
        text-align: center;
    }

    .white h1 {
        padding-top: 35px;
    }

    .white p {
        padding-top: 25px;
    }

    .border {
        width: 120px;
        height: 120px;
        border-radius: 60px;
        /*border: solid #000;*/
        background: #444;
        margin: auto 10px 10px auto;
    }

    .header {
        text-align: center;
        font-weight: bold;
        font-size: 26px;
    }

    .blogSpan {
        font-size: 30px;
        color: #007FFF;
        font-weight: bolder;
    }

    p {
        font-size: 14px;
        font-weight: normal;
        color: dimgrey;
    }
</style>
<body>
<div class="container">
    <div class="row">
        <br>

        <h1 class="header">A LITTLE ABOUT OUR <span class="blogSpan">TTBlog</span></h1>
        <hr>

        <div class="col-lg-6">
            <p>We believe ideas come from everyone, everywhere. In fact, at BlackTie, everyone within our agency walls
                is a designer in their own right. And there are a few principles we believe—and we believe everyone
                should believe—about our design craft. These truths drive us, motivate us, and ultimately help us
                redefine the power of design. We’re big believers in doing right by our neighbors. After all, we grew up
                in the Twin Cities and we believe this place has much to offer. So we do what we can to support the
                community we love.</p>
        </div>
        <!-- col-lg-6 -->

        <div class="col-lg-6">
            <p>Over the past four years, we’ve provided more than $1 million in combined cash and pro bono support to
                Way to Grow, an early childhood education and nonprofit organization. Other community giving involvement
                throughout our agency history includes pro bono work for more than 13 organizations, direct giving, a
                scholarship program through the Minneapolis College of Art & Design, board memberships, and ongoing
                participation in the Keystone Club, which gives five percent of our company’s earnings back to the
                community each year.</p>
        </div>
        <!-- col-lg-6 -->
    </div>
</div>

<%--<div class="teamBox">--%>
    <%--<div class="container">--%>
        <%--<div class="row">--%>
            <%--<!-- ==== TEAM MEMBERS ==== -->--%>
            <%--<br>--%>
            <%--<br>--%>

            <%--<h1 class="header white">MEET OUR AWESOME TEAM</h1>--%>
            <%--<br>--%>
            <%--<br>--%>

            <%--<div class="centered">--%>
                <%--<a><img class="border" src="http://placehold.it/100x100" alt="..."></a>--%>
                <%--<br>--%>
                <%--<h4 class="white teamName"><b>James Kwon</b></h4>--%>
                <%--&lt;%&ndash;<a href="#" class="icon icon-twitter"></a>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<a href="#" class="icon icon-facebook"></a>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<a href="#" class="icon icon-flickr"></a>&ndash;%&gt;--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>


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
