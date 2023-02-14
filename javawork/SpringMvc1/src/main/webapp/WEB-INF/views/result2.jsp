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
	<!-- 현재 프로젝트 경로를 구해서 변수에 저장 : http://localhost:9000/mvc1/ -->
	<c:set var="root" value="<%=request.getContextPath()%>"/>
	<img src="${root}/image/1.jpg" width="150">	
	<h2>HappyController로부터 호출</h2>
	<c:forEach var="s" items="${list}" varStatus="i">
		<h3 style="color: ${s}">${s}</h3>
	
	</c:forEach>
</body>
</html>