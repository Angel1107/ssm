<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'loginS.jsp' starting page</title>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
    	function isAdmin(){
			$.ajax({
			url : "<%=basePath%>room/checkAdmin",
			success : function(data) {
			if(data==true)
				 window.location.href ='<%=basePath%>room/tocreate';
			else
				alert("你没有权限去创建")				
			}
			});
}
    </script>
<style type="text/css">
a {
	font-family: 楷体;
	font-size: 26px;
}

a:link {
	text-decoration: none;
}

a:visited {
	color: blue;
	text-decoration: none;
}

a:hover {
	color: #000000;
	text-decoration: none;
}

a:active {
	color: #FFFFFF;
	text-decoration: none;
}

#sp {
	position: absolute;
	left: 40px;
	top: 6px;
}

#img1 {
	position: absolute;
	left: 10px;
	top: 5px;
	width: 30;
	height: 30;
}

#first {
	position: relative;
	top: 50
}
</style>

</head>

<body
	style="background-image: url(<%=basePath %>css/images/bg.jpg);background-size: cover;">
	<a href="http://i.baidu.com/center"> <img id="img1" alt="tt去哪儿了"
		src="<c:if test='${not empty user.imgUrl}'><%=basePath %>${user.imgUrl}</c:if><c:if test='${empty user.imgUrl}'><%=basePath %>upload/test.jpg</c:if>" /></a>
	<span id="sp"><a href="https://github.com/ManChuang">${user.username}个人中心</a></span>
	<div id="first" align="center">
		<a href="record/selectR.do/${user.id}">查看我预定的会议室</a><br />
		<br />
		<br /> <a href="javascript:isAdmin();">创建会议室</a>
		<!--   		<a href="img/toIndex">插件集成</a> -->
	</div>
</body>
</html>
