<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>博客后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
	<link href="${pageContext.request.contextPath }/css/manager.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">  
	<script src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(function(){
	 //文本框失去焦点后
	$('form :input').blur(function(){
    var $parent = $(this).parent();
    $parent.find(".formtips").remove();
    //验证用户名
    if( $(this).is('#username') ){
           if( this.value=="" || this.value.length < 5 ){
               var errorMsg = '请输入至少5位的用户名.';
               $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
           }else{
               var okMsg = '输入正确.';
               $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
           }
    }
    if( $(this).is('#newPwd') ){
           if( this.value=="" || this.value.length < 6 ){
               var errorMsg = '请输入至少6位的密码.';
               $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
           } else{
               var okMsg = '输入正确.';
               $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
           }
    }
    if( $(this).is('#newPwd2') ){
           if( this.value=="" || this.value.length < 6 ){
               var errorMsg = '请输入至少6位的密码.';
               $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
           } else if( this.value != $('#newPwd').val()){
                var errorMsg = '两次密码输入不一致.';
               $parent.append('<span class="formtips onError">'+errorMsg+'</span>');
           } else{
               var okMsg = '输入正确.';
               $parent.append('<span class="formtips onSuccess">'+okMsg+'</span>');
           }
    }
    });
});
</script>
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
    <form id="itemForm" method="post" action="${pageContext.request.contextPath }/back/bChangeAccount.do">
    <table id="dataMsg"  width="50%" align="center"  border="1">
      <caption>修改账号密码</caption>  
	  	<tr>
	  		<td align="center">*账户名：</td>
	  		<td><input id="username" type="text" name="uname" ></td>
	  	</tr>
	  	<tr>
	  		<td align="center">*原密码：</td>
	  		<td><input type="password" name="password" >
	  		<c:out value="${msg }"></c:out>
	  		</td>
	  	</tr>
	  	<tr>
	  		<td align="center">*新密码：</td>
	  		<td>
	  			<input id="newPwd" type="password" name="newPwd"  ><c:out value="${msgpwd }"></c:out>
	  		</td>
	  	</tr>
	  	<tr>
	  		<td align="center">*再输入密码：</td>
	  		<td><input id="newPwd2" type="password" name="newPwd2"  ></td>
	  	</tr>
	  	<tr> 
	  		<td align="center" colspan="2"><input id="subBtn" type="submit" value="更改" > 
	  			<input type="reset" value="清空" >
	  		</td>
	  	</tr>
    </table>
    </form>

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
});
  
  $("#li3").click(function(){
  	$("li").removeClass("active");
    $("#li3").addClass("active");
  });
  
  $("#li4").click(function(){
  	$("li").removeClass("active");
    $("#li4").addClass("active");
  });


});
</script>
</html>
