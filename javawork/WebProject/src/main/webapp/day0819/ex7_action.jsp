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
	
	div.box{
	width:400px;
	height:400px;
	border:2px solid gray;
	padding: 10px; 
	font-size: 20px;
	}

</style>
</head>
<body>
	<%
		//post방식은 !읽기 전에! 엔코딩 한줄 무조건 추가해야함 (한글 깨짐)
		request.setCharacterEncoding("UTF-8");
	
		String fcolor=request.getParameter("fcolor");
		String doll=request.getParameter("doll");
		String food=request.getParameter("food");
		//이때 선택하지 않으면 배열변수 자체가 null 이 되며, 선택하면 배열로 값이 넘어온다
		//select 에서 multiple 속성이 있으면 여러개 선택이 가능하므로 배열로 진행
		String []itlang=request.getParameterValues("itlang");
	%>
	
	<h3 class="alert alert-info">Ex7 폼태그로부터 읽은 값</h3>


		<div class="box" style="color: <%=fcolor %> ">
		글자색 : <%=fcolor %><br>
		선택한 인형 : <img src="../image/<%=doll %>" width="100px"> <br>
		오늘 점심 : <img src="../image/<%=food %>" width="100px"> <br>
		가능한 IT언어는? <br>
		<%	if(itlang==null){ %>
			구현 가능한 언어가 없어요 ㅠㅠ
		
		<%} else {
			for(String a:itlang){ %>
			<b><%=a %></b>&nbsp;

			<% } %>
			이정도 언어는 가능하죠!!!
		<% } %>
		</div>
</body>
</html>