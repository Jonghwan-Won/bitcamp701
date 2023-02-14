<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Anton&family=Edu+VIC+WA+NT+Beginner:wght@600&family=Gamja+Flower&family=Single+Day&family=Jua&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<style type="text/css">
* {
	font-family: 'Jua';
}
</style>
</head>
<body>
	<table class="table table-bordered" style="width: 800px;">
		<tr class="table-danger">
		<%
		for(int i=2;i<=9;i++){%>	<!-- 자바 영역 -->
		
			<td align="center"><b> <%=i %>단 </b></td>	<!-- HTML 영역 -->
			
		<% } %>
		</tr>

		<%	for(int i=1;i<=9;i++){	%>
				<tr>
				
				<% for(int j=2;j<=9;j++){	%>
					
					<td align="center">
					<%=j %> x <%=i %> = <%=j*i %>
					</td>
						
				<% } %>
				</tr>
			<% } %>
		
		</tr>
		
		<script>
			//자바스크립트, 제이쿼리도 모두 가능하다
			$("td").css("cursor","pointer");
			$("td").click(function() {
				$(this).css({
					color:'red',
					backgroundColor: "yellow"
				});
			});
		</script>
		
	</table>
</body>
</html>