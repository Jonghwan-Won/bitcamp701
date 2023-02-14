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
	<h4>Ex5 폼태그</h4>
	<form action="ex5_action.jsp" method="get">
	<!-- 웹에서 검색했을때 url에서 ?물음표 뒤에 입력값이 노출되는것 ...그래서 로그인에는 적합하지않음-->
	<!-- get방식으로 ex5_action.jsp 에 전달된다 -->
		<b>이 름 : </b>
		<input type="text" name="irum" class="form-control" style="width: 140px"
		placeholder="input Name" required>
		<br>
		<b>운전면허 : </b>
		<label><input type="checkbox" name="driver">운전면허</label>
		<br>
		<button type="button" class="btn btn-danger">서버전송</button>
		<!-- 폼단위로 읽는거 submit -->
		<!-- type=button 으로 했을땐 required 적용안됨 -->
	</form>
</body>
</html>