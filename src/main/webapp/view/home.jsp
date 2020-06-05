<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<a href="login"><spring:message code="global.login.link.title" /></a> | 
	<a href="register"><spring:message code="global.register.link.title" /></a>

	<div align="right">
		Select Language : <a href="?lang=en">English</a> | <a href="?lang=vi">VN</a>
	</div>
</body>
</html>