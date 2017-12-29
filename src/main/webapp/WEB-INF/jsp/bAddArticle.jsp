<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>博客后台管理系统-新增日志</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
	<link href="${pageContext.request.contextPath }/css/manager.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">  
	<script src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	
	<script charset="utf-8" src="${pageContext.request.contextPath }/js/kindeditor/kindeditor-all-min.js"></script>
	<script charset="utf-8" src="${pageContext.request.contextPath }/js/kindeditor/lang/zh-CN.js"></script>
	
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
    <form id="itemForm" method="post" action="${pageContext.request.contextPath }/back/bAddArtiComplete.do">
	    <table id="dataMsg"  width="80%" align="center"  border="1">
	      <caption>新增日志</caption>  
		  	<tr>
		  		<td width="15%" align="center">日志名称：</td>
		  		<td>
		  			<input type="text" name="title" style="width:100%">
		  		</td>
		  	</tr>
		  	<tr>
		  		<td width="15%" align="center">日志类别：</td>
		  		<td>
		  			<c:forEach items="${typeList}" var="msg">
		  				<label><input name="typeId" type="radio" value="${msg.id }" />${msg.typeName }</label> 
		  			</c:forEach>
		  			<label><input name="typeId" type="radio" value="0" />其他</label> 
		  			<input type="text" name="otherType" style="width:20%">
		  		</td>
		  	</tr>
		  	<tr>
		  		<td align="center">日志内容：</td>
		  		<td align="left">
		  			<textarea name="context" style="width: 100% ;height: 400px; visibility: hidden;"></textarea>
 				</td>
		  	</tr>
		  	<tr><td align="center" colspan="2"><input id="subBtn" type="button" value="提交"> </td></tr>
	    </table>
    </form>
  </body>
<script type="text/javascript">
	var artiEditor;
	$(document).ready(function(){
		artiEditor = KindEditor.create("#itemForm [name=context]" ,{
			filePostName : "uploadFile",
			uploadJson : '/img/upload.do' ,
			dir : "image"
		});
	});
	
	$("#subBtn").click(function(){
		artiEditor.sync();
		$("#itemForm").submit();
	});
</script>
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
