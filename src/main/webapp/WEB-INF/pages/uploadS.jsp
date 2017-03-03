<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
request.setAttribute("basePath", basePath);  
%>  
<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
<title>头像</title>  

</head>  
<body>  
<img src="${basePath}${ImgPath}" width="300" height="300">

	<c:forEach items="${imagesPathList}" var="image">  
    <img src="${basePath}${image}" width="300" height="200"><br/>  
	</c:forEach>  	
</body>  
</html> 