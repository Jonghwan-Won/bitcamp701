<%@page import="data.dto.SimpleBoardDto"%>
<%@page import="data.dao.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Anton&family=Edu+VIC+WA+NT+Beginner:wght@600&family=Gamja+Flower&family=Single+Day&family=Jua&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<style type="text/css">
	*{
		font-family: 'Jua';
	}
	
	b.submit{
		cursor: pointer;
		color: green;
	}
	
	b.submit:hover {
		color: red;
		text-shadow: 5px 5px 5px gray;
	}

</style>
<%
	//num읽기
	String num=request.getParameter("num");

	//dao선언
	SimpleBoardDao dao=new SimpleBoardDao();
	
	//num값에 해당하는 dto 가져오기
	SimpleBoardDto dto=dao.getContent(num);
%>
</head>
<body>
	<div style="margin: 30px 30px; width: 400px;">
		<form action="updateaction.jsp" method="post">
			<input type="hidden" name="num" value="<%=num%>">
			<table class="table table-bordered">
				<caption align="top"><h5><b><i class="bi bi-pencil-fill"></i>수정하기</b></h5></caption>
				<tr>
					<th width="100" class="table-secondary">작성자</th>
					<td>
						<input type="text" name="writer" class="form-control form-control-sm"
						required="required" autofocus="autofocus" style="width: 150px"
						value="<%=dto.getWriter()%>">
						<!-- autofoucs : 커서가 자동으로 위치하며 form 안에서 한군데에만 줄 수 있음 -->
					</td>
				</tr>
				<tr>
					<th width="100" class="table-secondary">제 목</th>
					<td>
						<input type="text" name="subject" class="form-control form-control-sm"
						required="required" value="<%=dto.getSubject()%>">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<label for="comment">Comments:</label>
						<textarea class="form-control" id="comment" name="content" 
						required="required" style="width: 100%; height: 100px;"><%=dto.getContent() %></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<!-- submit 기능을 이미지로 -->
						<!-- input type이 image거나 submit일 경우 기본 기능이 submit입니다 -->
						<label>
							<input type="image" src="../image/submit_btn.png" style="width: 20px;">
							<b class="submit" style="margin-right: 20px;">수정완료</b>
						</label>
						
						<button type="button" class="btn btn-secondary"
						style="margin-left: 30px;"
						onclick="location.href='boardlist.jsp'">목록으로</button>
					</td>
				</tr>
			
			</table>
		</form>
	
	</div>
</body>
</html>