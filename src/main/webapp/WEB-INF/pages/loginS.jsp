<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);  
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loginS.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	a{
	font-family:楷体;
	font-size: 26px;
	}
	a:link {
	text-decoration:none;
	}
	a:visited { 
	color:blue; 
	text-decoration:none; 
	} 
	a:hover { 
	color:#000000; 
	text-decoration:none; 
	} 
	a:active { 
	color:#FFFFFF; 
	text-decoration:none; 
	} 
	
	#sp{
	position: absolute;
	left:40px;
	top:6px;
	}
	
	#img1{
	position: absolute;
	left:10px;
	top:5px;
	width:30;
	height:30;
	}
	
	#first{
	position: relative;
    top: 50
	}
	
	</style>

  </head>
  
  <body style="background-image: url(css/images/bg.jpg);background-size: cover;">
	<a href="http://i.baidu.com/center" >	<img id = "img1" alt="tt去哪儿了" src="${basePath}${user.imgUrl}" ></a>
    <span id="sp"><a href="https://github.com/ManChuang" >${user.username}个人中心</a></span>
   		<div id="first" align="center">
  		<a href="record/selectR.do/${user.id}">查看我预定的会议室</a><br/><br/><br/>
  		<a href="room/tocreate">创建会议室</a>
  		</div>
  </body>
</html>
