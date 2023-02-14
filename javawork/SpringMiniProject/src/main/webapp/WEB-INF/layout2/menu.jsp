<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link
        href="https://fonts.googleapis.com/css2?family=Anton&family=Edu+VIC+WA+NT+Beginner:wght@600&family=Gamja+Flower&family=Single+Day&family=Jua&family=Nanum+Pen+Script&display=swap"
        rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>

    <style>
        li>a {
        	color: #bbb;
        	margin-right: 30px;
        	text-decoration: none;
        	font-size: 22px;
        }
        
        li>a:hover {
        	color: gray;
        }
        
        li{
        	float: left;
        	list-style: none;
        }

    </style>

</head>

<body>
	<c:set var="root" value="<%=request.getContextPath()%>"/>
	
	<!-- <div style="display: flex; justify-content: center;"> -->
	<div>
		<ul>
			<li><a href="${root}/"><i class='fas fa-home' style='font-size:20px'></i> 메인페이지</a></li>

			<li><a href="${root}/board/list"><i class='fas fa-list-ul' style='font-size:20px'></i> 게시판목록</a></li>
			<li><a href="${root}/board/form"><i class='fas fa-pencil-alt' style='font-size:20px'></i> 글쓰기</a></li>
			
			<li><a href="${root}/member/list"><i class='fas fa-user-alt' style='font-size:20px'></i> 회원목록</a></li>
			<li><a href="${root}/member/form"><i class='fas fa-address-card' style='font-size:20px'></i> 회원가입</a></li>
			
			<li><a href="${root}/help/map"><i class='fas fa-map-marked-alt' style='font-size:20px'></i> 오시는 길</a></li>
		</ul>
	</div>

</body>

</html>