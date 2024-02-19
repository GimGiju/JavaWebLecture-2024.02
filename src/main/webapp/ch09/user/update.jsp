<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>K-pop</title>
</head>
<body style="margin: 50px">
	<h1>유저 정보 수정</h1>
	<hr>
	<form action="/jw/ch09/user/update" method="post">
		<input type="hidden" name="uid" value="${user.uid}">
		<input type="text" value="${user.uid}" disabled><br><br>
		<input type="text" name="uname" value="${user.uname}"><br><br>
		<input type="password" name="pwd" value="${user.pwd}"><br><br>
		<input type="text" name="email" value="${user.email}"><br><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>