<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	pageContext.setAttribute("name", "페이지 변수");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Member</title>
	<style>
		td, th { padding: 3px;}
	</style>
</head>
<body style="margin: 50px;">
	<h1>Member</h1>
	<hr>
	
	<%-- 아이디열: 홀수면 글자색을 blue, 짝수면 red --%>
	<%-- 이름열: 첫번째줄 배경색을 yellow, 마지막 줄을 cyan --%>
	<%-- 주소열: 한국이면 배경색을 orange, 미국이면 skybule --%>
	<table border="1">
		<tr><th>아이디</th><th>이름</th><th>나이</th><th>국가</th></tr>
		<c:forEach var="member" items="${members}" varStatus="loop">
			<tr>
				<td>	<!-- 이이디 열: 홀수면 글자색을 blue, 짝수면 red -->
					<c:if test="${member.mid % 2 == 1}">
						<span style="color: blue">${member.mid}</span>
					</c:if>
					<c:if test="${member.mid % 2 == 0}">
						<span style="color: red">${member.mid}</span>
					</c:if>
				</td>
				<td>
					<c:if test="${loop.first}">
						<span style="background: yellow">${member.name}</span>
					</c:if>
					<c:if test="${loop.last}">
						<span style="background: cyan">${member.name}</span>
					</c:if>
					<c:if test="${not (loop.first or loop.last)}">
						<span style="background: beige">${member.name}</span>
					</c:if>
				</td>
				<td>
					<c:if test="${member.age < 20}">
						<span style="color: blue">${member.age}</span>
					</c:if>
					<c:if test="${member.age >=20}">
						<span style="color: red">${member.age}</span>
					</c:if>
					
				</td>
				<td>	<%-- 주소열: 한국이면 배경색을 orange, 미국이면 skybule --%>
					<c:if test="${member.country eq '한국'}">
						<span style="background: orange">${member.country}</span>
					</c:if>
					<c:if test="${member.country eq '미국'}">
						<span style="background: skyblue">${member.country}</span>
					</c:if>
					<c:if test="${member.country ne '한국' and member.country ne '미국'}">
						<span style="background: beige">${member.country}</span>
					</c:if>
				</td>
				
			</tr>
		</c:forEach>
	</table>
	<br>
</body>
</html>