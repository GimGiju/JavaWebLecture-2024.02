<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("name", "페이지 변수");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>표현 언어(EL)</title>
	<style>
		td, th { padding: 3px;}
	</style>
</head>
<body style="margin: 50px;">
	<h1>내장 객체(builtin object)</h1>
	<hr>
	<table border="1">
		<tr><th>계산식</th><th>결과</th></tr>
		<tr><th>\${empty param.id ? 10 : param.id}</th><th>${empty param.id ? 10 : param.id}</th></tr>
		<tr><th>\${applicationScope.aName}</th><th>${applicationScope.aName}</th></tr>
		<tr><th>\${sessionScope.sName}</th><th>${sessionScope.sName}</th></tr>
		<tr><th>\${requestScope.rName}</th><th>${requestScope.rName}</th></tr>
		<tr><th>\${requestScope.name}</th><th>${requestScope.name}</th></tr>
		<tr><th>\${pageScope.name}</th><th>${pageScope.name}</th></tr>
		<tr><th colspan="2">스코프 생략</th></tr>
		<tr><td>\${aName}</td><td>${aName}</td></tr>
		<tr><td>\${sName}</td><td>${sName}</td></tr>
		<tr><td>\${rName}</td><td>${rName}</td></tr>
		<tr><td>\${name}</td><td>${name}</td></tr>
		<tr><th colspan="2">헤더 정보</th></tr>
		<tr><td>\${header.host}</td><td>${header.host}</td></tr>
		<tr><td>\${header.cookie}</td><td>${header.cookie}</td></tr>
		<tr><td>\${header["User-Agent"]}</td><td>${header["User-Agent"]}</td></tr>
		<tr><th colspan="2">쿠기 정보</th></tr>
		<tr><td>\${cookie.JSESSIONID.name}</td><td>${cookie.JSESSIONID.name}</td></tr>  <!-- 개별적 쿠기의 이름 -->
		<tr><td>\${cookie.JSESSIONID.value}</td><td>${cookie.JSESSIONID.value}</td></tr>	<!-- 개별적 쿠기의 벨류 -->
</body>
</html>