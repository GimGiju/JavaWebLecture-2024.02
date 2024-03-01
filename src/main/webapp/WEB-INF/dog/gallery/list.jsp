<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/heart.css">
	<%@ include file="/WEB-INF/dog/common/_head.jspf" %>
	<style>
		td, th { text-align: center; }

		#heart{
    /*색 보충*/
    fill: #fdf8e7;

    /*stroke속성은 선, 문자, 원소등의 테두리에대해서 디자인 가능*/
    stroke: var(--c);
    /*선의 넓이*/
    stroke-width: 20px;
    /*선을 점선으로 설정, 점선의 길이 설정*/
    stroke-dasharray: 1000;
    /*displacement of line*/
    stroke-dashoffset: 1000;
    /*끝점은 둥글게*/
    stroke-linecap: round;
   
   border: 1px solid black;
    }
 
    
/*checkbox를 클릭할 경우 애니메이션 실행*/
#checkbox:checked + svg #heart{
    /*애니메이션실행: 애니메이션이름, 실행시간, 선형 마지막 정지한 프레임*/
    animation: drawHeart 1s linear forwards;
}

#checkbox:checked ~ span{
    /*애니메이션실행: 애니메이션이름, 실행시간, 선형 마지막 정지한 프레임*/
    animation: blink 0.5s ease-in-out forwards;
    /*애니메이션 딜레이*/
    animation-delay: 0.1s ;
}


#checkbox:checked + svg{
     /*애니메이션실행: 애니메이션이름, 실행시간, 선형 마지막 정지한 프레임*/
    animation: beat 1s linear forwards;;
}
label{
    /*마우스 heart로 이동시 마우스 커서변동*/
    cursor: pointer;
}
    
    /*애니메이션 효과 설정*/
/*heart 애니메이션*/
@keyframes drawHeart{
    0%{
        stroke-dashoffset: 2600;
    }

    100%{
        fill: red;
        stroke-dashoffset: 0;
        
    }

}

    svg{
    width: 100px;
    /*상대포지션*/
    position: relative;
    /*z-index: 10;*/
}
 		
  
	</style>
	<script>
		function deleteFunc(uId) {
			$('#deleteuId').val(uId);
			$('#deleteModal').modal('show');
		}
		
	</script>
</head>
<body style="height:1000px">


	<%@ include file="/WEB-INF/dog/common/_top.jspf" %>
	
	<div class="container" style="margin:80px 10px 0px 10px">
		<div class="row">
	<%@ include file="/WEB-INF//dog/common/_aside.jspf" %>
			
		<!-- 			본문입니다.								 -->
			<div class="col-9 ms-5 mt-5">
			<c:forEach var="gallery" items="${galleryList}" varStatus="loopStatus">
				<c:if test="${loopStatus.index % 3 eq 0}"> </c:if>
			        <div class="card" style="width:500px; height: 500px; margin-left: 450px; position: relative;">
			            <img class="card-img-top" src="/jw/dog/gallery/view?filename=${gallery.fName}" width="500px" height="500px" style="width:100%">
			            <label for="checkbox${loopStatus.index}" style="position: absolute; top:400px; left:15px;">
			                <input type="checkbox" id="checkbox${loopStatus.index}" hidden>
			                <svg t="1689815540548" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2271"><path d="M742.4 101.12A249.6 249.6 0 0 0 512 256a249.6 249.6 0 0 0-230.72-154.88C143.68 101.12 32 238.4 32 376.32c0 301.44 416 546.56 480 546.56s480-245.12 480-546.56c0-137.92-111.68-275.2-249.6-275.2z" fill="#231F20" p-id="2272" id="heart"></path></svg>
			                <span></span>
			            </label>
			        </div>
				 <c:if test="${loopStatus.index % 3 eq 2 or loopStatus.last}"></c:if>
			</c:forEach>
	<%@ include file="/WEB-INF/dog/common/_bottom.jspf" %>
		</div>
	</div>
</body>
</html>