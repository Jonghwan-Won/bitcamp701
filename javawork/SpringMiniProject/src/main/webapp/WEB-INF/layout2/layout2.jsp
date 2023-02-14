<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring5+Tiles3+Mybatis</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Anton&family=Edu+VIC+WA+NT+Beginner:wght@600&family=Gamja+Flower&family=Single+Day&family=Jua&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

<c:set var="root" value="<%=request.getContextPath()%>"/>
<!-- header 스타일 줄때 절대경로가 필요해서 추가했음 -->

<style type="text/css">
	body *{
		font-family: 'Jua';
		/* background-color: #121212; */
	}
	
	div.mainlayout1 div.main{
		border: 0px solid gray;
	}
	
	
	#header{
		width: 100%;
		height: 100px;
		/* text-align: center; */
		line-height: 100px;
		/* background-color: #c0c0c0; */
		color: #bbb;
		padding-left: 30px;
		/* background-color: #000; */
	}
	
	#menu{
		width: 100%;
		height: 50px;
		/* text-align: center; */
		line-height: 50px;
		/* color: #bbb; */
		/* background-color: #000; */
	}
	
	#info{
		float: left;
		width: 300px;
		height: 400px;
		/* background-color: #c0c0c0; */
		border: 1px solid gray;
		/* color: #bbb; */
		padding-left: 30px;
		padding-top: 30px;
		margin-left: 30px;
	}
	
	#main{
		float: left;
		/* width: 80%; */
		height: 500px;
		padding-left: 30px;
		/* margin-left: 350px; */
		/* background-color: #121212; */
	}
</style>
</head>
<body>
	<div class="mainlayout1">
		<div class="main" id="header">
			<tiles:insertAttribute name="header"/>
		</div>
		<div class="main" id="menu">
			<tiles:insertAttribute name="menu"/>
		</div>
		<br>
		
 		<div class="main" id="info">
			<tiles:insertAttribute name="info"/>
		</div>
		<div class="main" id="main">
			<tiles:insertAttribute name="main"/>
		</div>
		<div class="main" id="footer">
			<tiles:insertAttribute name="footer"/>
		</div>
	</div>
</body>
</html>