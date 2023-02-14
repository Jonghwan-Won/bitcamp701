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

	div{
	margin-left: 50px;
	font-size: 30px;
	}
	
	img{
	width: 200px;
	}
	
	pre{
	font-family: 'Jua';
	font-size: 20px;
	padding-left: 30px;
	}
	
</style>
</head>
<body>

<%
		//post방식은 !읽기 전에! 엔코딩 한줄 무조건 추가해야함 (한글 깨짐)
		request.setCharacterEncoding("UTF-8");
	
		String irum=request.getParameter("irum");
		String gender=request.getParameter("gender");
		String vaccine=request.getParameter("vaccine");
		//이때 선택하지 않으면 배열변수 자체가 null 이 되며, 선택하면 배열로 값이 넘어온다
				//select 에서 multiple 속성이 있으면 여러개 선택이 가능하므로 배열로 진행
		String []menu=request.getParameterValues("menu");
		String addr=request.getParameter("addr");
		String text=request.getParameter("text");
	%>
	
	<h3 class="alert alert-info">Ex8 폼태그로부터 읽은 값</h3>


		<div class="box">
		- 이 름 : <%=irum %><br>
		- 성 별 : <%=gender %><br>
		- 백신 여부 : <%=vaccine==null?"미접종":"접종완료" %> <br>
		- 좋아하는 메뉴는? <br>
		<% if(menu==null){ %>
			좋아하는 메뉴가 없습니다.
		
		<%} else {
			for(String img:menu){ %>
			<img src=<%=img %>>
			
		
			<%} %>
		<%} %> <br>
		
		- 주소 : <%=addr %><br>
		- 하고싶은 말? <br>
		<pre><%=text %></pre>
		
		
		
		</div>
	
</body>
</html>