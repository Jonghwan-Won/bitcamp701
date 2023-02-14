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
	<%
	//폼이 get 방식일경우 톰캣8 이후 한글 엔코딩을 안해도 된다
	String irum=request.getParameter("irum");	//request? 내장객체?
			
	//checkbox는 value가 따로 주어지지 않았을때 체크하면 default로 on을, 체크안하면 무조건 null
	String driver=request.getParameter("driver");
	%>
	
	<h3>폼으로부터 읽은 값</h3>
	<h3>이 름 : <%=irum %></h3>
	<h3>운전면허 : <%=driver==null?"없음":"있음" %></h3>
<%-- 	<h3>운전면허 : <%=driver.equals("on")?"있음":"없음" %></h3> --%>
	<!-- on일때는 잘 나오지만 null일때는 nullpoint exception이 발생함 -->
	
	
</body>
</html>