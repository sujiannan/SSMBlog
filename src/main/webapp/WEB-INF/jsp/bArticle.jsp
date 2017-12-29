<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>博客后台管理系统-文章管理</title>
    
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
    
    <table width="60%" align="center"  border="1">
    <caption><a href="${pageContext.request.contextPath }/back/bAddArti.do" >新增文章</a></caption>
      <caption>文章类别</caption>
      <tr>
	    <th width="50%" align="center">文章类别(Type)</th>
	    <th width="50%" align="center">操作</th>
	  </tr>
	  <c:forEach items="${typeList}" var="msg">
	  	<tr>
	  		<td id="${msg.id}">${msg.typeName }</td>
	  		<td>
	  			<a href="${pageContext.request.contextPath }/back/bDeleteArtiType.do?id=${msg.id }">删除</a> | 更改类别名称：
	  			<input id="${msg.id}"  type="text" name="typeName"><a onclick="submitTyeName(${msg.id })" href="javascript:none">更改</a>	
	  		</td>
	  	</tr>
	  </c:forEach>
    </table>
<script type="text/javascript">
function submitTyeName(tid){
	var typeName = $("input[id='"+ tid +"']").val();
	var jsonStr = '{"typeName":"'+typeName+'","id":"'+tid +'"}';
	//alert(jsonStr);
	$.ajax({
	    type: 'POST',
	    contentType:"application/json",
	    url: "${pageContext.request.contextPath }/back/bUpdateArtiType.do" ,
	    cache:false, 
	    data: jsonStr ,
	    dataType:"json",     
	    success: function(data) {
	    	var name = data['typeName'];
	    	var tid = data['id'];
	    	$("td[id='"+ tid +"']").text(name);
	    	$("input").val("");
	    } 
	});
}
	
</script>
    <table id="dataMsg"  width="60%" align="center"  border="1">
      <caption>文章列表</caption>
      <tr>
	    <th align="center">文章名称</th>
	    <th width="20%" align="center">Type</th>
	    <th width="20%" align="center">发表日期</th>
	    <th width="10%" align="center">操作</th>
	  </tr>
	  <c:forEach items="${artilist}" var="msg">
	  	<tr>
	  		<td>${msg.title }</td>
	  		<td>${msg.artiType.typeName }</td>
	  		<td><fmt:formatDate value="${msg.time }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	  		<td>
	  			<a href="${pageContext.request.contextPath }/back/bDeleteArti.do?id=${msg.id }">删除</a>
	  			<a href="${pageContext.request.contextPath }/back/bUpdateArti.do?id=${msg.id }">更改</a>	
	  		</td>
	  	</tr>
	  </c:forEach>
    </table>
    
	    
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
  $("#li4").click(function(){
  	$("li").removeClass("active");
    $("#li4").addClass("active");
  });


});
</script>
</html>
