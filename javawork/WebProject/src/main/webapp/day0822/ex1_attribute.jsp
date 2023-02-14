<%@page import="data.dto.StudentDto"%>
<%@page import="java.util.Vector"%>
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
	<h3>request 에 Vector 저장 후 불러오기 연습</h3>
	
	<%
	//데이터 넣기
	Vector<StudentDto> list=new Vector<>();
	list.add(new StudentDto("이영자","강남구",89));
	list.add(new StudentDto("홍길동","영등포구",67));
	list.add(new StudentDto("김진","제주도",100));
	list.add(new StudentDto("이효리","부산시",70));
			
	//데이터  Vector를 request에 저장
	request.setAttribute("list", list);
	
	//페이지 이동하는 두가지 방법
	//1. forward : url 주소가 변경되지 않음, request/response 등이 그대로 전달됨
	//2. redirect : url 주소가 변경됨, request/response가 새로 생성됨(=저장해놨더라도 전달되지않는다)
	
	
	/* jsp: 으로 시작하는 태그들을 액션 태그라고 한다
	반드시 닫아줘야함 </jsp:...>
	또는 <jsp:foward page="ex2_forward.jsp/"> 이런식으로 끝에 슬래시로 닫음 */
	%>
	
	<jsp:forward page="ex2_forward.jsp"/>
	
	
	
</body>
</html>

