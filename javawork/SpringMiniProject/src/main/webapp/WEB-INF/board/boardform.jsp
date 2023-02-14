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
	
	<form action="insert" method="post" enctype="multipart/form-data">
		<!-- 보이진않지만 폼 전송할때 같이 보내야하는 데이터 -->
		<input type="hidden" name="num" value="${num}">
		<input type="hidden" name="id" value="${sessionScope.loginid}">
		<input type="hidden" name="name" value="${sessionScope.loginname}">
		<input type="hidden" name="regroup" value="${regroup}">
		<input type="hidden" name="restep" value="${restep}">
		<input type="hidden" name="relevel" value="${relevel}">
		<input type="hidden" name="currentPage" value="${currentPage}">
		
		<table class="table table-boredered" style="width: 500px;">
			<tr>
				<th style="width: 100px;">제목</th>
				<td>
					<input type="text" name="subject" class="form-control" required="required"
					value="${subject}">
				</td>
			</tr>
			<tr>
				<th style="width: 100px;">사진</th>
				<td>
					<input type="file" name="upload" class="form-control" multiple="multiple">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea name="content" class="form-control" required="required" style="width: 500px;height: 150px;"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-outline-secondary">게시글 저장</button>
				</td>
			</tr>
		</table>
		
	</form>
</body>
</html>