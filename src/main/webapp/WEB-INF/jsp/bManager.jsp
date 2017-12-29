<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>博客后台管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${pageContext.request.contextPath }/css/manager.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">  
	<script src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  </head>
  
  <body>
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="${pageContext.request.contextPath }/back/bManager.do">后台管理系统</a>
        </div>
        
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li id="li1"><a href="${pageContext.request.contextPath }/back/bManager.do">Home</a></li>
            <li id="li2"><a href="${pageContext.request.contextPath }/back/bMsg.do">管理留言</a></li>
            <li id="li4"><a href="${pageContext.request.contextPath }/back/bArticle.do">管理日志</a></li>
            <li id="li5"><a href="${pageContext.request.contextPath }/back/bAccount.do">账号管理</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="${pageContext.request.contextPath }/bLogout.do">Log out</a></li>
            <li><a href="${pageContext.request.contextPath }/index.do">返回博客</a></li>
          </ul>
        </div><!--/.nav-collapse -->
        
      </div>
    </nav>

    <div class="container" id="huanyingjiemian">
      <div class="jumbotron">
        <h1>欢迎你进入后台管理系统</h1>
  	  </div>  
    </div> 
    
  </body>
<script>
$(document).ready(function(){
  $("#li1").click(function(){
  	$("li").removeClass("active");
    $("#li1").addClass("active");
    $("#huanyingjiemian").show();
  });
  $("#li2").click(function(){
  	$("li").removeClass("active");
    $("#li2").addClass("active");
    $("#huanyingjiemian").hide(); 
  });

  $("#li4").click(function(){
  	$("li").removeClass("active");
    $("#li4").addClass("active");
  });


});
</script>
</html>
