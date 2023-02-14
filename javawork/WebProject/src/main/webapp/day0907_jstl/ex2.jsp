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
<style type="text/css">
	*{
		font-family: 'Jua';
	}

	body {
		margin: 30px 30px;
	}
</style>
</head>
<body>
	<!-- 한글 엔코딩 -->
	<!-- post방식이므로 엔코딩없으면 한글 깨짐 -->
	<fmt:requestEncoding value="utf-8"/>
	
	<form action="ex2.jsp" method="post" style="width: 400px;">
	<h3>이름을 입력해주세요</h3>
	<input type="text" name="irum" class="form-control" value="테스트">
	
	<h3>가고싶은 나라를 입력해주세요</h3>
	<input type="text" name="nara" class="form-control" placeholder="가고싶은 나라 입력">
	<br>
	<button type="submit" class="btn btn-dark">결과 확인</button>
	</form>
	<hr>
	
	<!-- param : 파라미터 -->
	<!-- 이름을 입력했을때만 결과가 나오도록 해보자 -->
	<!-- if 조건문 -->
	<c:if test="${!empty param.irum}">
		<h3>이름 : ${param.irum }</h3>
		<h3>가고싶은 나라 : ${param.nara }</h3>
		
		<!-- choose 조건문 -->
		<c:choose>
			<c:when test="${param.nara=='캐나다' }">
				<h3 style="color: green;">캐나다 항공비는 200만원 입니다</h3>
			</c:when>
			<c:when test="${param.nara=='하와이' }">
				<h3 style="color: orange;">하와이 항공비는 190만원 입니다</h3>
			</c:when>
			<c:when test="${param.nara=='괌' }">
				<h3 style="color: magenta;">괌 항공비는 100만원 입니다</h3>
			</c:when>
			<c:when test="${param.nara=='뉴욕' }">
				<h3 style="color: gray;">뉴욕 항공비는 250만원 입니다</h3>
			</c:when>
			<c:otherwise>
				<h3 style="color: red;">${param.nara }로 가는 비행기는 없습니다</h3>
			</c:otherwise>
			
		</c:choose>
	</c:if>
</body>
</html>