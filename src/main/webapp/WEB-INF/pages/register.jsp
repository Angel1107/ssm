<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<base href="<%=basePath%>photo/">
<head>
<title>My JSP 'register.jsp' starting page</title>
<script src="../js/jquery-1.11.3.min.js" type="text/javascript"></script>
<!-- 	<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script> -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="cropper/cropper.min.css" rel="stylesheet">
<link href="sitelogo/sitelogo.css" rel="stylesheet">
<script src="cropper/cropper.min.js"></script>
<script src="sitelogo/sitelogo.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){  
		$("#username").blur(function() {
		var login_username = $("#username").val();
		$.ajax({
		url : "<%=basePath%>user/check",
		data : {username : login_username},
		success : function(data) {
		if(data=='N')
		$("#error").html("用户名不可用！").css({"color":"red"});
		else{
			if(login_username=="")
				$("span").css('display','none');
			else
			$("#error").html("用户名可用...").css({"color":"blue"});
			}
		}
		});
		});
		
		$("#image").click(function(){
			//alert("123")
			//alert($("#mypic").attr('src'));
			  $.ajax({
             type: "POST",
             url: "<%=basePath%>user/register.do",
             data: {username:$("#username").val(), password:$("#password").val(),phone:$("#phone").val(),file:$("#mypic").attr('src')},
             success: function(data){
					//alert("注册成功");
					window.location.href ='<%=basePath%>';
                  }
         });
		});
		   /*
			*图片上传并回显
			*/
		$("#upsubmit").click(function(){
			var formData = new FormData($( "#uploadForm" )[0]);    
				$.ajax({
					 type: "POST",
					 url: "<%=basePath%>user/upimg",
					  data: formData,    
         			  async: false,    
			          cache: false,    
			          contentType: false,    
			          processData: false,    
					 success: function(data){
						$("#close").unbind('click').click();
						$("#mypic").attr("src","<%=basePath%>"+data);
						//alert(data);
						//$("#upfile").val(data)
					 }
				});
				
		})
		
})
	</script>
<style type="text/css">
#img {
	margin: 0 auto;
	width: 80px;
	height: 60px;
}

.file input {
	margin: 0 auto;
	width: 180px
}

.center {
	margin: 0 auto;
}

.avatar-view {
	width: 80px;
	height: 60px;
}
</style>
</head>

<body
	style="background-image: url(../css/images/bg.jpg);background-size: cover;"
	align="center">
	<%--   <form action="<%=basePath%>user/register.do" method="post" align="center" enctype="multipart/form-data"><br><br> --%>
	<span id="error"></span>
	<br> 用户账号:
	<input type="text" id="username" name="username" required="required"
		placeholder="请输入你的用户名">
	<br>
	<br> 用户密码:
	<input type="text" id="password" name="password" required="required"
		placeholder="请输入你的密码">
	<br>
	<br> 电话号码:
	<input name="phone" id="phone"
		pattern="(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$"
		required="required" type="text" placeholder="请输入11位电话号码">
	<br>
	<br> 电子邮箱:
	<input type="email" id="email" placeholder="请输入你的的邮箱">
	<br>
	<br> 上传头像
	<div id="img">
		<div class="ibox-content">
			<div class="row">
				<div id="crop-avatar" class="col-md-6">
					<div class="avatar-view" title="Change User Picture">
						<img id="mypic" src="logo.jpg" alt="Logo">
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<div class="center">
		<input id="image" type="image" src="../css/images/zc.png" alt="注册"
			width="105px">
	</div>

	<div class="modal fade" id="avatar-modal" aria-hidden="true"
		aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<form class="avatar-form" action="<%=basePath%>user/upimg"
					id="uploadForm" enctype="multipart/form-data" method="post">
					<div class="modal-header">
						<button id="close" class="close" data-dismiss="modal"
							type="button">&times;</button>
						<h4 class="modal-title" id="avatar-modal-label">Change User
							Picture</h4>
					</div>
					<div class="modal-body">
						<div class="avatar-body">
							<div class="avatar-upload">
								<input class="avatar-src" name="avatar_src" type="hidden">
								<input class="avatar-data" name="avatar_data" type="hidden">
								<label for="avatarInput">图片上传</label> <input
									class="avatar-input" id="avatarInput" id="upfile" name="file"
									type="file">
							</div>
							<div class="row">
								<div class="col-md-9">
									<div class="avatar-wrapper"></div>
								</div>
								<div class="col-md-3">
									<div class="avatar-preview preview-lg"></div>
									<div class="avatar-preview preview-md"></div>
									<div class="avatar-preview preview-sm"></div>
								</div>
							</div>
							<div class="row avatar-btns">
								<div class="col-md-9">
									<div class="btn-group">
										<button class="btn" data-method="rotate" data-option="-90"
											type="button" title="Rotate -90 degrees">
											<i class="fa fa-undo"></i> 向左旋转
										</button>
									</div>
									<div class="btn-group">
										<button class="btn" data-method="rotate" data-option="90"
											type="button" title="Rotate 90 degrees">
											<i class="fa fa-repeat"></i> 向右旋转
										</button>
									</div>
								</div>
								<div class="col-md-3">
									<button class="btn btn-success btn-block avatar-save"
										type="button" id="upsubmit">
										<i class="fa fa-save"></i> 保存修改
									</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>

	<!--      <div class="file"><input type="file" name="file" id="file"><br></div>	 -->

	<!--     	<input type = "submit" value="注册"> -->
	<!--   </form> -->
</body>
</html>
