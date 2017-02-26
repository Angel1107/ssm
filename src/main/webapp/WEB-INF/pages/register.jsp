<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(function(){  
		$("#username").blur(function() {
		
		var login_username = $("#username").val();
		$.ajax({
		url : "user/check",
		data : {username : login_username},
		success : function(data) {
		if(data=='N'){
		$("#error").html("用户名不可用！").css({"color":"red"});
		alert("111111")}
		else{
			if(login_username=="")
				$("span").css('display','none');
			else
			$("#error").html("用户名可用...").css({"color":"blue"});
			}
		}
		});
		});
})
		
	</script>
  </head>
  
  <body style="background-image: url(css/images/bg.jpg);background-size: cover; ">
  <form action="user/register.do" method="post" align="center" enctype="multipart/form-data"><br><br>
<!--   	<div style="width:600px;margin:0px auto;border:1px solid red;"> -->
<span id="error"></span><br>
    	用户账号: <input type = "text" id="username" name="username" required="required" placeholder="请输入你的用户名"><br><br>
    	用户密码: <input type = "text" name="password" required="required" placeholder="请输入你的密码"><br><br>
    	电话号码: <input name="phone" pattern="(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$" required="required" type="text" placeholder="请输入11位电话号码"><br><br>
    	电子邮箱: <input type="email" placeholder="请输入你的的邮箱"><br><br>
    	用户头像：<input type="file" name="file"><br><br>
    	<input type="image" src="css/images/zc.png"  alt="注册" width="105px"> 
<!--     	<input type = "submit" value="注册"> -->
<!-- 	</div> -->
  </form>
  </body>
</html>
