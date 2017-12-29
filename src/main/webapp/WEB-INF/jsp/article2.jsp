<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Su Jiannan's Article</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath }/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Theme CSS -->
    <link href="${pageContext.request.contextPath }/css/clean-blog.min.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath }/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/css/go.css" rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath }/css/go2.css" rel='stylesheet' type='text/css'>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/article.css" />
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
    <header class="intro-header" style="background-image: url('${pageContext.request.contextPath }/img/post-bg.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="site-heading">
                        <h1>记录起始点</h1>
                        <hr class="small">
                        <span class="subheading">A little knowledge is dangerous</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- start site's main content area -->
    <section class="content-wrap">
        <div class="container">
            <div class="row">
				<main class="col-md-8 main-content">
					<c:forEach items="${artiInfo.list}" var="msg">
						<div>
							<div class="post-head">
								<h1 class="post-title"><a href="${pageContext.request.contextPath }/detail/${msg.id }">${msg.title }</a></h1>
								<div class="post-meta">
									<span class="author">Posted by：SU Jiannan</span> &nbsp; &bull; &nbsp;
									<time class="post-date" ><fmt:formatDate value="${msg.time }" pattern="yyyy-MM-dd HH:mm:ss" /></time>
								</div>
							</div>
							<div>
								<p style="font-size:16px;font-family:'Microsoft YaHei', u5FAEu8F6Fu96C5u9ED1, Arial, SimSun, u5B8Bu4F53;">
									${msg.context }
								</p>
							</div>
							<div class="post-permalink">
								<a href="${pageContext.request.contextPath }/detail/${msg.id }" class="btn btn-default">阅读全文</a>
							</div>
						</div>
						<hr/>
					</c:forEach>
					<p style="font-size:16px;font-family:'Microsoft YaHei', u5FAEu8F6Fu96C5u9ED1, Arial, SimSun, u5B8Bu4F53;">
						<a id="uppage" class="newer-posts" href="${pageContext.request.contextPath }/type/${type_id }/${artiInfo.nowPage-1 }">上一页</a>
						<span class="page-number">第 ${artiInfo.nowPage } 页/共 ${artiInfo.totalPage } 页</span>
						<a id="downpage" class="older-posts" href="${pageContext.request.contextPath }/type/${type_id }/${artiInfo.nowPage+1 }">下一页</a>
					</p>
                </main>
			
				<aside class="col-md-4 sidebar">
					<div>
						<h2 class="title">TYPE</h2>
						<hr/>
						<div id="typeId">
							<c:forEach items="${typeList}" var="msg">
								<a href="${pageContext.request.contextPath }/type/${msg.id }/1">✔${msg.typeName }</abbr></a>  <br/>
							</c:forEach>
						</div>
						<hr/>
					</div>
					
				</aside>
			</div>
		</div>
	</section>
    
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

<script type="text/javascript">
	$(function(){
		var newPage = ${artiInfo.nowPage };
		var totalPage =  ${artiInfo.totalPage };
		if(newPage <= 1) {
			$("#uppage").hide();
		} else {
			$("#uppage").show();
		}
		if(newPage >= totalPage) {
			$("#downpage").hide();
		} else {
			$("#downpage").show();
		}
		
	});
</script>
</body>

</html>
