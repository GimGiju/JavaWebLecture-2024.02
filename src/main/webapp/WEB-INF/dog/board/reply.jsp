<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/_head.jspf" %>
</head>
<body>
	<%@ include file="../common/_top.jspf" %>

    <div class="container" style="margin-top:80px">
        <h3>댓글 목록</h3>
        <div id="comments">
            <c:if test="${not empty replyList}">
                <c:forEach var="reply" items="${replyList}">
                    <div class="comment">
                        <p><strong>작성자:</strong> ${reply.replyId}</p>
                        <p><strong>내용:</strong> ${reply.comment}</p>
                        <p><strong>작성일:</strong> ${fn:substring(reply.createdDate, 0, 10)}</p>
                        <hr>
                    <form action="/jw/dog/reply/delete" method="post">
                    <input type="hidden" name="replyId" value="${reply.replyId}" />
                    <input type="submit" value="삭제" onclick="return confirm('정말 삭제하시겠습니까?');"/>
                    </form>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${empty replyList}">
                <p>댓글이 없습니다.</p>
            </c:if>
        </div>
    </div>
	<%@ include file="../common/_bottom.jspf" %>
</body>
</html>