<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showRecord.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		td{	width:100px}
		table,table td{border:1px solid red;}
	</style>
 
  </head>
   <body style="background-image: url(css/images/bg.jpg);background-size: cover;">
   			<br><br><br>
  		<table align="center" cellspacing="0">
  		<tr align="center"><td>记录编号</td><td width="105">预定人</td><td>会议室名</td><td>描述</td><td style="width:300px;">预定时间</td></tr>
  			<c:forEach items="${rlst}" var="r">
  			 <tr align="center">
  			 	 <td>${r.id}</td>
  			 	 <td>${r.user.username}</td>
  			 	 <td>${r.room.name}</td>
  			 	 <td>${r.content}</td>
  			 	 <td><fmt:formatDate value="${r.createtime}" pattern="yyyy-MM-dd hh:mm:ss.SSS"/></td>
  			 </tr>
  			</c:forEach>
  		</table>
  </body>
</html>
