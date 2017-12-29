<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Su Jiannan's - About</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath }/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="${pageContext.request.contextPath }/css/clean-blog.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath }/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/css/go.css" rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath }/css/go2.css" rel='stylesheet' type='text/css'>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-custom navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath }/index.do">Dream page</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
					<li>
                        <a href="${pageContext.request.contextPath }/index.do">Home</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/article/1">Article</a>
                    </li>
					<li>
                        <a href="${pageContext.request.contextPath }/about.do">About Me</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath }/contact.do">Contact Me</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Header -->
    <!-- Set your background image for this header on the line below. -->
    <header class="intro-header" style="background-image: url('${pageContext.request.contextPath }/img/about-bg.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="page-heading">
                        <h1>About Me</h1>
                        <hr class="small">
                        <span class="subheading">This is what I do.</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Main Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<div id="w">
					<header class="clearfix">
						<div id="info">			
							<h1><span>张三(San ZHANG) 199X.XX.XX</span></h1>
							<h3><span itemprop="jobTitle">求职需求: Java后端工程师</span></h3>
							<small itemprop="address" itemscope itemtype="http://schema.org/PostalAddress">
							  <span itemprop="addressLocality">XX大学</span>, 
							  <span itemprop="addressRegion">XX市</span>, 
							  <span itemprop="addressCountry">XX省</span>
							</small>
							<br/>
							<small><span itemprop="email">30778992@qq.com</span></small>
						</div>
					</header>
					<hr/>
					<!--
					<section id="profile">
						<h2>My History &amp; Profile</h2>
						<p itemprop="description">I'm a 21 year old web designer and developer working out of eastern Massachusetts. I have been coding websites ever since sophomore year of high school in my first web design class. Fast-forward a few years later I was landing freelance projects most of my junior and senior years. During this time I was also working part-time at Best Buy's Geek Squad division.</p>
						
						<p>After graduating High School in summer 2009 I started writing on various web design blogs along with launching my own startup ideas. A few months later in September 2009 I spent a couple months studying at <a href="http://www.wpi.edu/">Worcester Polytechnic Institute</a> in Worcester, Massachsuetts. However I left in January 2010 to pursue a career on my own. I now work doing freelance writing and building side-projects in my spare time.</p>
					</section>
					-->
					<section id="skills" class="clearfix" itemscope itemtype="http://schema.org/ItemList">
						<h2 itemprop="name">Skillset</h2>
						<section id="skills-left">
							<h4 itemprop="about">Development</h4>
							<ul>
								<li itemprop="itemListElement">Java</li>
								<li itemprop="itemListElement">了解JavaScript &amp; jQuery</li>
								<li itemprop="itemListElement">Python &amp; C(熟悉)</li>
								<li itemprop="itemListElement">SQL Databases</li>
								<li itemprop="itemListElement">SSM框架</li>
								<li itemprop="itemListElement">Linux</li>
								<li itemprop="itemListElement">了解Redis非关系型数据库</li>
								<li itemprop="itemListElement">...</li>
							</ul>
						</section>
						
						<section id="skills-right">
							<h4 itemprop="about">English level &amp; Computer skill</h4>
							<ul>
								<li itemprop="itemListElement">CET-6</li>
								<li itemprop="itemListElement">Cisco Certified Network Associate</li>
								<li itemprop="itemListElement">计算机等级二级C</li>
								<li itemprop="itemListElement">计算机等级三级网络</li>
							</ul>
						</section>
					</section>
					
					<section id="education">
						<h2>Education</h2>
						<ul>
							<li itemprop="itemListElement">XX大学 20XX.X-20XX.X 硕士</li>
							<li itemprop="itemListElement">XX大学 20XX.X-20XX.X 本科</li>
						</ul>
					</section>
					
					<section id="experience">
						<h2>Work Experience</h2>
						<p>XXX公司 Java后端工程师 ~ 20XX.X-20XX.X</p>
					</section>
				</div>
            </div>
        </div>
    </div>

    <hr>

    <!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <p class="copyright text-muted">Copyright &copy; sui1.cn 2016-2017  联系邮箱：3078992@qq.com
                    <a href="${pageContext.request.contextPath }/login.do">后台登录</a></p>
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath }/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath }/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="${pageContext.request.contextPath }/js/jqBootstrapValidation.js"></script>
    <script src="${pageContext.request.contextPath }/js/contact_me.js"></script>

    <!-- Theme JavaScript -->
    <script src="${pageContext.request.contextPath }/js/clean-blog.min.js"></script>

</body>

</html>
