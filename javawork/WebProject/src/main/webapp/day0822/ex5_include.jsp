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
	<h3 class="alert alert-danger">include-다른 파일의 결과페이지를 현재 페이지에 포함시킨다</h3>
	<!-- include 도 액션태그 -->
	<jsp:include page="../day0819/ex2_gugudan.jsp"/>
	<!-- 따로 전달할게 없으므로 그냥 닫기 / -->
	<hr>
	<jsp:include page="../day0819/ex7_formtag.jsp"/>
	
</body>
</html>