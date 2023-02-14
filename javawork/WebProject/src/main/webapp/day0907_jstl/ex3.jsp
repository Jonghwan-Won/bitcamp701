<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
		font-size: 20px;
		font-weight: bold;
	}
	
	body {
		margin: 30px 30px;
	}

</style>
</head>
<body>
<%
	//변수 list에 해당 값들을 추가한다
	List<String> list=new ArrayList<>();
	list.add("red");
	list.add("orange");
	list.add("yellow");
	list.add("green");
	list.add("blue");
	list.add("navy");
	list.add("purple");
	
	//"list" 라는 이름으로 list의 데이터들을 보냄
	request.setAttribute("list", list);
	//"total"이라는 이름으로 list의 길이를 보냄
	request.setAttribute("total", list.size());
	
	//세션에 아이디를 저장해보자
	session.setAttribute("id", "angel");
%>

<!-- 반복문 forEach -->
<!-- begin 시작 / end 끝 / step 증감크기 -->
1~10까지 출력하기<br>
<c:forEach var="a" begin="1" end="10">
	${a}&nbsp;
</c:forEach>
<br><br>

<h3>0~30까지 3의 배수 출력하기</h3>
<c:forEach var="a" begin="0" end="30" step="3">
	${a}&nbsp;
</c:forEach>
<hr>

<h3>list에는 총 ${total}개의 색상이 들어있습니다</h3>
<%-- ${변수명} 일때 앞에 requestScope가 생략되어있음, request에 저장된 데이터는
자바처럼 getAttribute로 얻지 않아도 바로 출력이 가능하다
하지만 세션에 저장된 데이터 출력시 sessionScope.변수명 으로 출력해야한다 --%>

<h3>list에는 총 ${requestScope.total}개의 색상이 들어있습니다</h3><br>

<h3>세션 아이디 출력</h3>
<!-- session.getAttribute 안해도됨 -->
<h3>현재 로그인한 아이디는 ${sessionScope.id} 입니다</h3>
<hr>

<h3>list 전체를 테이블로 출력하기</h3>
<table class="table table-bordered" style="width: 300px;">
	<tr>
		<th>번호</th><th>인덱스</th><th>색상</th>
	</tr>
	
	<c:forEach var="s" items="${list}" varStatus="i">
		<tr>
			<td>${i.count }</td> <!-- 무조건 1번부터 출력 -->
			<td>${i.index }</td> <!-- 실제 list의 index값이 출력 -->
			<td>
				<b style="color: ${s};">${s}</b>
	
	</c:forEach>
	
</table>


<h3>list 인덱스 2부터 4까지 테이블로 출력하기</h3>
<table class="table table-bordered" style="width: 300px;">
	<tr>
		<th>번호</th><th>인덱스</th><th>색상</th>
	</tr>
	
	<c:forEach var="s" items="${list}" begin="2" end="4" varStatus="i">
		<tr>
			<td>${i.count }</td> <!-- 무조건 1번부터 출력 -->
			<td>${i.index }</td> <!-- 실제 list의 index값이 출력 -->
			<td>
				<b style="color: ${s};">${s}</b>
	
	</c:forEach>
	
</table>


</body>
</html>