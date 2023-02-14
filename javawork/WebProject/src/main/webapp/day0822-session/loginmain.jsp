<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here 로그인메인</title>
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
	<%
		//세션으로부터 loginok 를 얻어서 null이 아닐경우 logoutform 을 나타낸다
		//null 일 경우는 loginform 을 나타낸다
		
		String loginok=(String)session.getAttribute("loginok");
	
		if(loginok==null)
		{ 
	%>
		<jsp:include page="loginform.jsp"/>
	
	<%} else { %>
		<jsp:include page="logoutform.jsp"/>
	<%}	%>
	
	
</body>
</html>



