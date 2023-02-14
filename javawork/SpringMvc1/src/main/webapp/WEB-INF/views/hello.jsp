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
		margin: 50px 50px;
	}

</style>
</head>
<body>
	<h2>HomeController 로 부터 포워드됨</h2>
	<h3>오늘 날짜: <fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm"/></h3>
	<h3>메세지 : ${message}</h3>
	<hr>
	<h2 class="alert alert-info">매핑주소 연습</h2>
	<h4><a href="board/list">board/list</a></h4>
	<h4><a href="board/list.do">board/list.do</a></h4>
	<h4><a href="board/list.bit">board/list.bit</a></h4>
	<!-- 
	<img src="image/10.jpg" width="150">
	<img src="res/image2/아이스카페라떼.JPG">
	 -->
	 <hr>
	 <h2>HappyController 로 부터 포워드됨</h2>
	 <h4><a href="happy">happy</a></h4>
	 <h4><a href="hello">hello</a></h4>
	 <h4><a href="bit/show">bit/show</a></h4>
	 
	 <hr>
	 <h2>StudyController 로 부터 포워드됨 - 예제1 </h2>
	 <h4><a href="bit/study1">bit/study1</a></h4>
	 <h4><a href="bit/study2">bit/study2</a></h4>
	 
 	 <hr>
	 <h2>ShopController 로 부터 포워드됨 - 예제2 ShopDto</h2>
	 <h4><a href="bit/shop">나의 shop 상품정보</a></h4>

</body>
</html>