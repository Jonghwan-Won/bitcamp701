<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.CarsellerDto"%>
<%@page import="data.dao.CarSellerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link
	href="https://fonts.googleapis.com/css2?family=Anton&family=Edu+VIC+WA+NT+Beginner:wght@600&family=Gamja+Flower&family=Single+Day&family=Jua&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<style type="text/css">
	*{
		font-family: 'Jua';
	}

	span.day{
	color: #aaa;
	font-size: 0.8em;
	}

</style>
</head>
<body>

<jsp:useBean id="dao" class="data.dao.CarSellerDao"/>

	<%
		//num을 읽는다
		String num=request.getParameter("num");
		
		//dao 선언
		/* CarSellerDao dao=new SimpleBoardDao(); */
		/* useBean으로 사용하려면 스크립트릿 밖에서 */
		
		//조회수 1 증가
		dao.updateReadCount(num);
		
		//num에 해당되는 dto 가져오기
		CarsellerDto dto=dao.getContent(num);
		
		//날짜 형식
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	%>
	
	<div style="margin: 30px auto; width: 700px;">
		<table class="table table-bordered">
			<caption align="top"><h2><b>
				<%=dto.getCarname()%> / <%=dto.getCaryear() %>년식 / <%=dto.getCarcolor() %>
				</b></h2></caption>
			<tr>
				<td>
					<b>작성자 : <%=dto.getWriter() %></b><br>
					<span class="day"><%=sdf.format(dto.getWriteday()) %>
					&nbsp;&nbsp;조회수 <%=dto.getReadcount()%>
					</span>
				</td>
			</tr>
			<tr height="150">
				<td>
					<!-- 여러줄을 입력했어도 출력시 한줄로 나온다
					해결방법 : 1.pre태그 안에 쓴다
							 2.db저장 시 br태그가 \n으로 저장된다
							   그러므로 출력시 다시 br로 변환을 해야한다 -->
							   
					<%=dto.getContent().replace("\n", "<br>") %>
					
					<!-- textarea는 html태그나 이미지img 태그를 인식함 -->
					<!-- [예시] 내용에 <h4 style="color: blue;"> 내용내용내용<h4> -->
				</td>
			</tr>
			<tr>
				<td align="center">
					<button type="button" class="btn btn-primary"
						onclick="location.href='sellboardform.jsp'">
						<i class="bi bi-pencil-square"></i> 새글작성</button>&nbsp;&nbsp;
						
					<button type="button" class="btn btn-secondary"
						onclick="location.href='carboard.jsp'">
						<i class="bi bi-list-ul"></i> 목록으로</button>&nbsp;&nbsp;
						
					<button type="button" class="btn btn-success"
						onclick="location.href='updatepassform.jsp?num=<%=dto.getNum()%>'">
						<i class="bi bi-pencil-fill"></i> 수정하기</button>&nbsp;&nbsp;
						
					<button type="button" class="btn btn-danger"
						onclick="location.href='deletepassform.jsp?num=<%=dto.getNum()%>'">
						<i class="bi bi-trash"></i> 삭제하기</button>
					
				</td>
			</tr>
		</table>
	</div>
	
</body>
</html>