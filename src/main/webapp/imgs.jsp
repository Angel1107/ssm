<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>多图片上传</title>
</head>
<body>
	<form action="img/uploads" method="post" enctype="multipart/form-data">
		<label>头 像1</label><input type="file" name="file" /><br /> <label>头
			像2</label><input type="file" name="file" /><br /> <input type="submit"
			value="提  交" />
	</form>
</body>
</html>