<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("newline", "\n"); %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/_head.jspf" %>
	<style>
		td, th { text-align: center; }
	</style>
	<script>
 		function deleteFunc(boardId) {
 			//console.log(boardId);
			$('#deleteBoardId').val(boardId);
			$('#deleteModal').modal('show');
		}
	</script>
	

</head>
<body style=" height: 2000px">
	<%@ include file="../common/_top.jspf" %>
	
	<div class="container" style="margin-top:80px">
		<div class="row">
			
			<!-- ====================== 본문 영역 =========================== -->
		<div class="col-9">
			<h3><strong class="me-5">게시글 보기</strong>
				<span style="font-size: 16px">
						<a href="/jw/dog/board/list?p=${currentBoardPage}&f=${field}&q=${query}"><i class="fa-solid fa-table-list"></i>목록</a>
				<c:if test="${sessUid eq board.uId}">	<!-- 본인만 수정 가능 -->
						<a href="/jw/dog/board/update?boardId=${board.boardId}"><i class="fa-solid fa-file-pen ms-3"></i>수정</a>
						<a href="javascript:deleteFunc('${board.boardId}')"><i class="fa-solid fa-trash ms-3"></i>삭제</a> <!--  onclick="del()" -->
				
				</c:if>
				<c:if test="${sessUid ne board.uId}">	
						<a href="#" class="disabled-link"><i class="fa-solid fa-file-pen ms-3"></i>수정</a>
						<a href="#" class="disabled-link"><i class="fa-solid fa-trash ms-3"></i>삭제</a>
				</c:if>
				</span>
			</h3>
			<hr>
            <div class="row">
                <h3><strong>${board.title}</strong></h3>
                <div class="col-12 text-end">
                    <h6>글 번호: ${board.boardId} | ${fn:replace(board.modTime, "T", " ")}</h6>
                    <h6>조회 ${board.viewCount} &nbsp;&nbsp; 댓글 ${board.replyCount}</h6>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-12">
                    ${fn:replace(board.content, newline, '<br>')}
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-12">
                    <c:forEach var="reply" items="${replyList}">
	                        <div class="d-flex flex-row mt-1">
	                            <div class="card bg-light text-dark w-75">
	                                <div class="card-body">
	                                    ${reply.uId}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${fn:replace(reply.regTime, "T", " ")}<br> 
	                                    ${fn:replace(reply.comment, newline, '<br>')}  <!-- content -->
	                                </div>
	                            </div>
	                        </div>
                    </c:forEach>
                </div>
            </div>
						<!-- ====================== 본문 영역 =========================== -->
        </div>
	</div>
	
	<%@ include file="../common/_bottom.jspf" %>
	<div class="modal" id="deleteModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">게시글 삭제</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>
			
				<!-- Modal body -->
				<div class="modal-body">
					<strong>정말로 삭제하시겠습니까?</strong>
					<div class="text-center mt-5">
						<form action="/jw/dog/board/delete" method="post">
							<input type="hidden" id="deleteBoardId" name="boardId">
							<button class="btn btn-danger" type="submit">삭제</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

    <div class="row mt-4">
        <div class="col-9">
            <form action="/jw/dog/board/insertReply?boardId=${board.boardId}" method="post">
                <input type="hidden" name="boardId" value="${board.boardId}">
                <div class="row mb-2">
                    <div class="col-lg-12">
                        <textarea class="form-control" id="comment" name="comment" rows="3" placeholder="댓글을 입력해주세요."></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <button type="submit" class="btn btn-primary btn-sm">등록</button>
                    </div>
                </div>
            </form>
        </div>
    </div>


</body>
</html>