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
	<table class="table table-bordered" style="width: 600px">
		<tr valign="middle" align="center">
			<th width="50">번호</th>
			<th width="200">상품명</th>
			<th width="150">색상</th>
			<th>가격</th>
		</tr>
		
		<!-- 반복문으로 데이터 꺼내기 -->
		<c:forEach var="dto" items="${list}" varStatus="n">
		<!-- 번호 붙이려면 varStatus 하고 변수는 맘대로 -->
			<tr>
				<td align="center">${n.count}</td>
				<td align="center">${dto.sangpum}</td>
				<td style="background-color:${dto.color}">${dto.color}</td>
				<td align="right">
					<fmt:formatNumber value="${dto.price}" type="currency"/>
				</td>
			</tr>
		</c:forEach>
		
	
	</table>
</body>
</html>