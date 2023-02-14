<%@page import="data.dto.MyShopDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.MyShopDao"%>
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
		margin: 50px 300px;
	}

</style>
</head>
<body>
<%
	MyShopDao dao=new MyShopDao();
	List<MyShopDto> list=dao.getAllSangpums();
	
	request.setAttribute("list", list);
	/* request에 넣어야 for문으로 꺼낼수있음 */
	
%>

<h3 class="alert alert-dark" style="width: 800px;">MyShop 목록</h3>

<table class="table table-bordered" style="width: 800px;">
	
	<tr valign="middle" style="background-color: lightgray;">
		<th>번호</th><th>상품명</th><th>색상</th><th>가격</th><th>입고일</th><th>등록일</th>
	</tr>
	
	<!-- 반복문 시작 -->
	<!-- i가 갖고있는 index 와 count를 사용하기위해 varStatus='i' -->
	<c:forEach var="dto" items="${list }" varStatus="i">
	<!-- dto는 임의의 변수 이름을 선언한거임 -->
	<!-- var="a" 였으면 밑에서 데이터 꺼낼때 a.color 이렇게하면됨 -->
	
		<tr valign="middle">
			<td style="text-align: center;">${i.count}</td>
			<td>
				<img src="../image2/${dto.photo}.jpg" style="width: 50px;">&nbsp;&nbsp;
				<span>${dto.sangpum}</span>
			</td>
			<td style="text-align:center;">
				<div class="rounded-circle" style="background-color: ${dto.color}; width:50px; height:50px;"</div>
				<span>${dto.color}</span>
			</td>
			<td style="text-align: right;">
				<fmt:formatNumber value="${dto.price}" type="currency"/><br>
				<!-- 현재 화폐단위로 출력, 3자리마다 컴마 -->
			
				<!-- if를 사용해서 비싸면 고가제품 저렴하면 저가제품 출력 -->
				<c:if test="${dto.price>80000}">
					<b style="color: red;">고가 제품</b>
				</c:if>
				<c:if test="${dto.price<20000}">
					<b style="color: blue;">저가 제품</b>
				</c:if>
			</td>	
			
			<td>${dto.ipgoday}</td>
			<td>
				<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH시"/>
			</td>
			
		</tr>
	</c:forEach>
	
	

</table>

</body>
</html>