<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<script>
        window.onload = function() {
            var checkboxes = document.querySelectorAll('input[type="checkbox"]');
            checkboxes.forEach(function(checkbox) {
                checkbox.addEventListener('change', function() {
                    var heart = this.nextElementSibling.querySelector('svg #heart');
                    if (this.checked) {
                        heart.style.fill = 'red';
                    } else {
                        heart.style.fill = 'white';
                    }
                });
            });
        };


    </script>
<link rel="stylesheet" href="./css/heart.css">
	<%@ include file="/WEB-INF/view/dog/common/_head.jspf" %>
	<style>
		td, th { text-align: center; }

  #heart {
    /* 기존 스타일 유지 */
    /* 체크박스 선택 시 색상 변경 애니메이션 */
    transition: fill 0.5s ease; /* 애니메이션 속성 설정 */

    /* 애니메이션 효과를 위한 기본 색상 */
    fill: white;



}
label{
    /*마우스 heart로 이동시 마우스 커서변동*/
    cursor: pointer;
}

/* 체크박스 선택 시 하트 색상 변경 */
#checkbox:checked + svg #heart {
    fill: red;
}


    svg{
    width: 100px;
    /*상대포지션*/
    position: relative;
    /*z-index: 10;*/
}


#heart2 {
    fill: red;
}

	</style>

</head>
<body>

	<%@ include file="/WEB-INF/view/dog/common/_top.jspf" %>

	<div class="container" style="margin:80px 10px 0px 10px">
		<div class="row">
	<%@ include file="/WEB-INF/view/dog/common/_aside.jspf" %>

		<!-- 			본문입니다.								 -->
			<div class="col-9 ms-5 mt-5">
			<c:forEach var="gallery" items="${galleryList}" varStatus="loopStatus">
                <c:if test="${loopStatus.index % 3 eq 0}"> </c:if>
                <div class="card mb-5" style="width:499px; margin-left: 400px; position: relative;">
                    <div style="height: 326px; overflow: hidden;">
                        <img class="card-img-top" src="/jw/dog/gallery/view?filename=${gallery.fName}" style="width:499px; height:326px">
                    </div>
                    <div style="margin: 10px 0px 0px 10px; display: inline-block;">
                        <span style="text-align: center;">제목: ${gallery.title} <br>
                            <hr>
                            작성자: ${gallery.uId}
                            <hr>
                            좋아요 개수: ${gallery.likeCount}
                            <br><br><br>

                            <c:if test="${sessUid eq gallery.uId}">
                                <!-- 본인만 수정 가능 -->
                                <span style="font-size: 16px;">
                                    <a href="/jw/dog/gallery/update?galleryId=${gallery.galleryId}"><button class="btn btn-secondary me-3">수정</button></a>
                                    <a href="javascript:deleteFunc('${gallery.galleryId}')"><button class=" btn btn-danger">삭제</button></a>
                                </span>
                            </c:if>
                            <c:if test="${sessUid ne gallery.uId}">
                                <span style="font-size: 16px;">
                                    <a href="#" class="disabled-link"><button class="btn btn-secondary me-3">수정</button></a>
                                    <a href="#" class="disabled-link"><button class=" btn btn-danger">삭제</button></a>
                                </span>
                            </c:if>
                        </span>
                        <c:if test="${sessLiked.toString() != '1'}">
                            <label for="checkbox${loopStatus.index}" style="position: absolute; top:230px; left:15px;">
                                <input type="checkbox" id="checkbox${loopStatus.index}" onclick="window.location.href='/jw/dog/gallery/like?galleryId=${gallery.galleryId}&uId=${sessUid}&isChecked=' + this.checked;" hidden>
                                <svg t="1689815540548" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2271">
                                    <path d="M742.4 101.12A249.6 249.6 0 0 0 512 256a249.6 249.6 0 0 0-230.72-154.88C143.68 101.12 32 238.4 32 376.32c0 301.44 416 546.56 480 546.56s480-245.12 480-546.56c0-137.92-111.68-275.2-249.6-275.2z" fill="#231F20" p-id="2272" id="heart2"></path>
                                </svg>
                                <span></span>
                            </label>
                        </c:if>
                         <c:if test="${sessLiked.toString() == '1'}">
                        <label for="checkbox${loopStatus.index}" style="position: absolute; top:230px; left:15px;">
                            <input type="checkbox" id="checkbox${loopStatus.index}" onclick="window.location.href='/jw/dog/gallery/like?galleryId=${gallery.galleryId}&uId=${sessUid}&isChecked=' + this.checked;" hidden>
                            <svg t="1689815540548" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2271">
                                <path d="M742.4 101.12A249.6 249.6 0 0 0 512 256a249.6 249.6 0 0 0-230.72-154.88C143.68 101.12 32 238.4 32 376.32c0 301.44 416 546.56 480 546.56s480-245.12 480-546.56c0-137.92-111.68-275.2-249.6-275.2z" fill="#231F20" p-id="2272" id="heart"></path>
                            </svg>
                            <span></span>
                        </label>
                        </c:if>
                    </div>
                </div>
                <c:if test="${loopStatus.index % 3 eq 2 or loopStatus.last}"></c:if>
            </c:forEach>

		</div>
	</div>
</div>
	<%@ include file="/WEB-INF/view/dog/common/_bottom.jspf" %>

	<div class="modal" id="deleteModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">갤러리 삭제</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<strong>정말로 삭제하시겠습니까?</strong>
					<div class="text-center mt-5">
						<form action="/jw/dog/gallery/delete" method="post">
							<input type="hidden" id="deleteGalleryId" name="galleryId">
							<button class="btn btn-danger" type="submit">삭제</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>

