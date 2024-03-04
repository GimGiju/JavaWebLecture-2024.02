<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		td, th { padding: 3px; }
	</style>
</head>
<body style="margin: 50px">
	<h1>상품 조회</h1>
	<hr>
	<table border="1">
		<tr><td>제목</td><td>${gallery.title}</td></tr>
		<tr><td>이미지</td><td><img src="/jw/dog/gallery/view?filename=${gallery.fName}"></td></tr>
	</table>
</body>
</html>