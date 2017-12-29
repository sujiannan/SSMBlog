<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录后端管理页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${pageContext.request.contextPath }/css/login.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">  
	<script src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
  </head>
  
  <body>
    <div class="container">
      <form action="${pageContext.request.contextPath }/back/loginCheck.do" class="form-signin" method="post" >
        <h2 class="form-signin-heading">Please sign in</h2><br/>
        <input type="text" name="uname" id="idusername" class="form-control" placeholder="请输入管理员账户" required >
        <input type="password" name="password" id="idpassword" class="form-control" placeholder="请输入密码" required >
        <div class="checkbox">
          <label>
             <c:if test="${msg != null }">
             	${msg }
             </c:if>
          </label> 
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <button id="backButton" class="btn btn-lg btn-primary btn-block" type="button"> 返  回  </button>
     	<script>
     		$(document).ready(function(){
     			$("#backButton").click(function(){
     				location.href="${pageContext.request.contextPath }/index.do";
     			});
     		});
    	 </script>
      </form>
    </div>
  </body>
</html>
