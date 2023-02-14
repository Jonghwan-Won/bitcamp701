<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Anton&family=Edu+VIC+WA+NT+Beginner:wght@600&family=Gamja+Flower&family=Single+Day&family=Jua&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
	*{
		font-family: 'Jua';
	}
	
	.page-item.active .page-link {
	    background-color: gray;
	    border-color: gray;
	}

	.page-link {
    	color: black;
	}
	
	/* 미리보기 스타일 셋팅 */
	#preview{
		z-index: 9999;
		position:absolute;
		border:0px solid #ccc;
		background:#333;
		padding:1px;
		display:none;
		color:#fff;
	}
	
	/* 가로 방향 정가운데, 세로 정가운데 줄 경우 top:50% */
	#wrap{
		position: absolute;
		top: 95%;
		left: 35%;
		transform:translate(-50%,-50%);		
	}
	
</style>

<script type="text/javascript">
            $(document).ready(function() {
                 
                var xOffset = 10;
                var yOffset = 30;

                $(document).on("mouseover",".thumbnailPhoto",function(e){ //마우스 오버시
					
					$("body").append("<p id='preview'><img src='"+ $(this).attr("src") +"' width='300px' /></p>"); //보여줄 이미지를 선언
					/* $("body").append("<p id='preview'><img src='"+ $(this).attr(${dto.photo}) +"' width='400px' /></p>"); //보여줄 이미지를 선언 */
					$("#preview")
						.css("top",(e.pageY - xOffset) + "px")
						.css("left",(e.pageX + yOffset) + "px")
						.fadeIn("fast"); //미리보기 화면 설정 셋팅
				});
				
				$(document).on("mousemove",".thumbnailPhoto",function(e){ //마우스 이동시
					$("#preview")
						.css("top",(e.pageY - xOffset) + "px")
						.css("left",(e.pageX + yOffset) + "px");
				});
				
				$(document).on("mouseout",".thumbnailPhoto",function(){ //마우스 아웃시
					$("#preview").remove();
				});
                 
            });
</script>
        
</head>
<body>
	<!-- <h1>boardlist 화면</h1> -->


<div class="boardlist" style="margin-top: 10px;">
	<h3 class="alert alert-secondary">총 ${totalCount} 개의 글이 있습니다</h3>
	<br>
	<a href="list?searchcolumn=id&searchword=${sessionScope.loginid}"
			style="color: gray; font-size: 24px; text-decoration: none;">
		<i class='fas fa-list'></i> 내가 작성한 글목록
	</a>
	<table class="table">
		<tr style="background-color: #ddd;">
			<th style="width: 50px;">번호</th>
			<th style="width: 350px;">제목</th>
			<th style="width: 100px;">작성자</th>
			<th style="width: 110px;">작성일</th>
			<th style="width: 50px;">조회</th>
			<th style="width: 60px;">좋아요</th>
		</tr>
		<c:if test="${totalCount==0}">
			<tr>
				<td colspan="6" align="center">
					<h4>등록된 글이 없습니다</h4>
				</td>
			</tr>
		</c:if>
		<c:if test="${totalCount>0}">
			<c:forEach var="dto" items="${list}">
				<tr>
					<!-- 번호 -->
					<td align="center">${no}</td>
					<c:set var="no" value="${no-1}"/>
					
					<!-- 제목 -->
					<td>
						<!-- 답글일 경우 level 1당 2칸 띄우기 -->
						<c:forEach begin="1" end="${dto.relevel}">
							&nbsp;&nbsp;
						</c:forEach>
						
						<!-- 답글일 경우 답글 이미지 넣기 -->
						<c:if test="${dto.relevel>0}">
							<img src="../image/re.png">
						</c:if>
						
						<a href="detail?num=${dto.num}&currentPage=${currentPage}" style="color: black; text-decoration: none;">
						${dto.subject}
						 
						<c:if test="${dto.photo!='no'}">
							<!-- <i class="fa fa-picture-o thumnail" style="font-size:20px; color: gray"></i> -->
							<img src="../upload/${dto.photo}" class="thumbnailPhoto" style="width: 20px;">
						</c:if>
						 
						 <!-- 댓글 갯수 표시 (0개 이상) -->
						<c:if test="${dto.acount>0}">
							<span style="color: red">(${dto.acount})</span>
						</c:if>
						 
						</a>
						
						
						
					</td>
					<!-- 작성자 -->
					<td align="center">${dto.name}</td>
					<!-- 작성일자 -->
					<td align="center">
						<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd"/>
					</td>
					<td align="center">${dto.readcount}</td>
					<td align="center">${dto.likes}</td>
				</tr>
			</c:forEach>
		</c:if>
		<tr style="border-bottom: 0px;">
			<td colspan="6" align="right" style="border: 0px;">
				<div class="searcharea" style="width: 100%; text-align: center;">
					<form action="list">
						<div class="input-group" style="width: 100%;">
							<!-- form태그라서 name으로 읽음 -->
							<select class="form-select" style="width: 150px; border-radius: 5px;" name="searchcolumn">
								
								<!-- 해당 옵션들을 컬럼으로 할거라서 컬럼명과 일치시키기 -->
								<option value="subject">제목</option>
								<option value="id">아이디</option>
								<option value="name">작성자</option>
								<option value="content">내용</option>
							</select>
							&nbsp;&nbsp;&nbsp;
							<input type="text" name="searchword" class="form-control" style="width: 300px; border-radius: 5px;"
							placeholder="검색 단어" value="${param.searchword}">
							
							<button type="submit" class="btn btn-dark" style="border-radius: 3px;">검색</button>
							&nbsp;&nbsp;&nbsp;
							
							<!-- 글쓰기 버튼은 로그인을 해야만 보인다 -->
							<c:if test="${sessionScope.loginok!=null}">
								<button type="button" class="btn btn-outline-dark" style="float: right; border-radius: 3px;"
								onclick="location.href='form'">
								<i class='fas fa-pencil-alt'></i> 글쓰기</button>
							</c:if>
						</div>
					</form>
				</div>
			</td>
		</tr>
	</table>
	
	<div class="paging" id="wrap">
		<ul class="pagination">
			
			<!-- 이전 -->
			<c:if test="${startPage>1}">
				<li class="page-item"><a href="list?currentPage=${startPage-1}" class="page-link">이전</a></li>
			</c:if>
			
			<!-- 페이지 번호 -->
			<c:forEach var="pp" begin="${startPage}" end="${endPage}">
				
				<!-- 현재 페이지 active(파란색) 효과 -->
				<c:if test="${pp==currentPage}">
					<li class="page-item active"><a class="page-link" href="list?currentPage=${pp}">${pp}</a></li>
				</c:if>
				
				<!-- 그 외 페이지 -->
				<c:if test="${pp!=currentPage}">
					<li class="page-item"><a class="page-link" href="list?currentPage=${pp}">${pp}</a></li>
				</c:if>
			</c:forEach>
			
			<!-- 다음 -->
			<c:if test="${endPage<totalPage}">
				<li class="page-item"><a href="list?currentPage=${endPage+1}" class="page-link">다음</a></li>
			</c:if>
		</ul>
		
	</div>
	
</div>
<br>


<br>

</body>
</html>