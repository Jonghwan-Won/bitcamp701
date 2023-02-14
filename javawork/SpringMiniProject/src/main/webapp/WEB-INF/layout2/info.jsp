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
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>	<!-- bs5 아이콘 -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"> <!-- bs5 구글 아이콘 -->
<style type="text/css">
	*{
		font-family: 'Jua';
		/* background-color: #c0c0c0; */
		color: #bbb; 
	}
	
	a.link {
		text-decoration: none;
		color: #bbb;
	}

	a.link:hover {
		color: gray;
	}
	
	div.box1{
		/* color: #bbb; */
	}
</style>
</head>
<body>
	<!-- <h1>info 화면</h1> -->
	<c:set var="root" value="<%=request.getContextPath() %>"/>
	
	<img src="${root}/image/오목눈이2.jpg" width="130" height="130"
	 class="rounded-circle">
	<br><br>
	
	<i class="material-icons" style="font-size: 20px; color: #bbb;">email</i>
	&nbsp;bitcamp@gmail.com<br>
	
	<i class="material-icons" style="font-size: 20px; color: #bbb;">person_outline</i>
	&nbsp;비트캠프 재직<br>
	
	<i class="fas fa-phone" style="font-size: 16px; color: #bbb;"></i>
	&nbsp;02-1234-1234<br>
	
	<br><br>
	<div class="box1">
	<a class="link" href="https://www.instagram.com/" target='_blank'>
	<i class='fab fa-instagram' style='font-size:20px; color: magenta'></i>&nbsp;인스타</a>&nbsp;&nbsp;
	
	<a class="link" href="https://www.facebook.com/" target='_blank'>
	<i class='fab fa-facebook-square' style='font-size:20px; color: blue'></i>&nbsp;페이스북</a>&nbsp;&nbsp;
	
	<a class="link" href="https://www.youtube.com/" target='_blank'>
	<i class='fab fa-youtube' style='font-size:24px; color: red'></i>&nbsp;유튜브</a>
	</div>
	
</body>
</html>