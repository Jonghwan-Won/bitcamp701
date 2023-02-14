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
	<div style="margin: 50px 50px; font-size: 20px;">
		<h3 class="alert alert-dark" style="width: 500px;">Form4 업로드한 여러개의 사진 확인하기</h3>
		<h3>총 ${count} 개의 사진을 업로드했어요</h3>
		<h4>사진 설명 : ${dsec}</h4>
		
		<!-- 연결되어있는 문자열을 특정 기호로 분리하기 -->
		<c:forTokens var="myimg" items="${photo}" delims=",">
			<img src="../upload/${myimg}" style="max-width: 130px;" border="1">&nbsp;&nbsp;
		</c:forTokens>

	</div>
</body>
</html>