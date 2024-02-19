<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>사용자 관리</title>
	<style>
		th{padding: 3px; text-align: center;}
		td{padding: 3px;}
	</style>
</head>
<body style="margin: 50px;">
	<h1>
		사용자 목록
		<button style="margin-left: 100px" onclick="location.href='/jw/ch09/user/register'">회원가입</button>
		<span style="font-size: 16px">
		<c:if test="${empty sessUid}">   <!-- 세션 uid가 비어있으면 / 로그인을 하지 않았을 때 -->
			<a style="margin-left: 100px" href="/jw/ch09/user/login">로그인</a>
		</c:if>
		<c:if test="${not empty sessUid}">   <!-- 세션 uid가 비어있으면 / 로그인을 했을때 -->
			<a style="margin-left: 100px" href="/jw/ch09/user/logout">로그아웃</a>
			<span style="margin-left: 30px">${sessUname}님 환영합니다.</span>
		</c:if>
		</span>
	</h1>
	<hr>
	<table border="1">
		<tr><th>아이디</th><th>이름</th><th>이메일</th><th>등록일</th><th>액션</th></tr>
		<c:forEach var="user" items="${list}"> 			<!-- 리스트 안에서 반복이 일어남 -->
			<tr>
				<td>${user.uid}</td>
				<td>${user.uname}</td>
				<td>${user.email}</td>
				<td>${user.regDate}</td>
				<td>
					<c:if test="${user.uid eq sessUid}">			<!-- 본인만 수정 가능/ 본인이 본인 정보를 입력할때만 사용가능 -->
						<a href="/jw/ch09/user/update?uid=${user.uid}">수정</a>
					</c:if>
					<c:if test="${user.uid ne sessUid}">
						<a herf="#" disabled>수정</a>
					</c:if>
					<!-- 본인 또는 관리자만 삭제 가능 -->
					<c:if test="${(user.uid eq sessUid) or (sessUid eq 'admin')}">
						<a href="/jw/ch09/user/delete?uid=${user.uid}">삭제</a>
					</c:if>
					<c:if test="${(user.uid ne sessUid) and (sessUid ne 'admin')}">
						<a herf="#" disabled>삭제</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
</body>
</html>