<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h3 class="alert alert-info">include.jsp 에 include2.jsp 결과를 포함시켜보자</h3>
	<h4>안녕하세요. 여기는 include1 입니다</h4>
	<img src="../image/01.png">
	<hr>
	
	<h3>아래 결과는 include2 입니다</h3>
	<jsp:include page="ex6_include2.jsp">
		<jsp:param value="../image/02.png" name="imgname"/>
		<!-- imgname이라는 이름으로 value(데이터)를 보냄 -->
		<jsp:param value="Happy Day!!!" name="message"/>
		<!-- message라는 이름으로 value(데이터)를 보냄 -->
		
		<!-- include2.jsp 에서 받아야하므로 getParameter를 사용해야함 -->
	</jsp:include>
	
</body>
</html>