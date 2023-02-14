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
	margin: 100px 100px;
}

</style>
</head>
<body>
	<h3 class="alert alert-dark">Get 방식 폼</h3>
	<form action="process1" method="get">
		<b>이름</b>
		<input type="text" name="name" class="form-control" style="width: 200px;">
		<br>
		<b>주소</b>
		<input type="text" name="addr1" class="form-control" style="width: 200px;">
		<br>
		<button type="submit" class="btn btn-dark">서버에 전송</button>
	</form>
</body>
</html>