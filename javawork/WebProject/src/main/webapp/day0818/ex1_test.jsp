<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<!-- HTML 주석 -->
	<%--JSP 주석-비실행 --%>
	<h3>JSP 는 Java Server Page의 약자입니다</h3>
	<img src="../image/01.png">

	<%	//자바 영역 scriptlet이라 부른다 (스크립트릿)
		//여기서 선언한건 지역변수가 됨
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String day=sdf.format(date);
		out.print(day);	//out: 내장 걕체 : JSP Writer -> 브라우저로 출력됨
	%>

	<script type="text/javascript">
		document.write("hello");
	</script>
	
</body>
</html>


