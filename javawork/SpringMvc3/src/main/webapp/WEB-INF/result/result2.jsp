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

</style>
</head>
<body>
	<div style="margin: 50px 50px; font-size: 20px; color: ${fontcolor}">
		<h3 class="alert alert-dark" style="width: 400px;">Form1 으로부터의 결과</h3>
		<h4>이 름 : ${name}</h4>
		<h4>핸드폰 : ${hp}</h4>
		<h4>자바 점수 : ${java}</h4>
		<h4>스프링 점수 : ${spring}</h4>
		
		<c:set var="tot" value="${java+spring}"/>
		<c:set var="avg" value="${tot/2}"/>
		
		<h4>총 점 : ${tot}</h4>
		<h4>평 균 : ${avg}</h4>
	</div>
</body>
</body>
</html>