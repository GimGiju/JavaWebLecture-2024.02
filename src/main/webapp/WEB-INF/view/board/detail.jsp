<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("newline", "/n"); %>


<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/_head.jspf" %>
	<style>
		td, th { text-align: center; }
		.disabled-link { pointer-events: none; }
	</style>
</head>
<body>
	<%@ include file="../common/_top.jspf" %>
	
	<div class="container" style="margin-top:80px">
		<div class="row">
			<%@ include file="../common/_aside.jspf" %>
			
			<!-- =================== 본문 영역 ===================== -->
			<div class="col-9">
				<h3><strong class="me-5">게시글 보기</strong>\
					<c:if test="${sessUid eq board.uid}">		<!-- 본인만 수정/삭제 가능한 기능 -->
						<span style="font-size:16px">
							<a href="/jw/bbs/board/update?bid=${board.bid}"><i class="fa-solid fa-file-pen"></i>수정</a>
							<a href="/jw/bbs/board/delete?bid=${board.bid}"><i class="fa-solid fa-trash ms-3"></i>삭제</a>
						</span>
					</c:if>
					<c:if test="${sessUid ne board.uid}">		<!-- 본인만 수정/삭제 가능한 기능 -->
						<span style="font-size:16px">
							<a href="#" class="disabled-link"><i class="fa-solid fa-file-pen"></i>수정</a>
							<a href="#" class="disabled-link"><i class="fa-solid fa-trash ms-3"></i>삭제</a>
						</span>
					</c:if>
				</h3>
				<hr>
				<div class="row"></div>
					<div class="co-8">
						<h5>${board.title}</h5>
						<h6>글번호: ${board.bid} | ${fn.replace(board.modtime, "T", " ")} </h6>
					</div>
					<div class="co-4" text-end>
						<h5>${board.uname}</h5>
						<h6>조회수: ${board.viewCount} &nbsp;&nbsp; 댓글: ${board.replyCount}</h6>
					</div>
					<hr>
					<div class="col-12">
						${fn:replace(board.content, newline, '<br>')}
					</div>
			</div>
			<!-- =================== 본문 영역 ===================== -->
		</div>
	</div>
	
	<%@ include file="../common/_bottom.jspf" %>
	
</body>
</html>