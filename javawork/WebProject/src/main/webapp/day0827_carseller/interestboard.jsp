<%@page import="data.dto.CarsellerDto"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dao.CarSellerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link
	href="https://fonts.googleapis.com/css2?family=Anton&family=Edu+VIC+WA+NT+Beginner:wght@600&family=Gamja+Flower&family=Single+Day&family=Jua&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<style type="text/css">
	*{
		font-family: 'Jua';
	}
	
	td>a{
		text-decoration: none;
		color: black;
	}
	
	td>a:hover {
		color: blue;
		text-decoration: underline;
	}
	
	th {
		text-align: center;
	}

</style>
</head>

<%
	//dao 선언
	CarSellerDao dao=new CarSellerDao();

	//체크 갯수
	int chkCount=dao.getChkCount();
	
	//전체 갯수
	int totalCount=dao.getTotalCount();

	//체크 데이터
	List<CarsellerDto> list=dao.getChkDatas();

	//게시판 날짜 형식
	SimpleDateFormat dt=new SimpleDateFormat("yyyy-MM-dd");
%>

<body>
	<div style="margin: 50px auto; width: 850px;">
		
		<h2><b>관심글 모아보기</b></h2>
		<table class="table table-bordered">
			<caption align="top">
				<b style="font-size: 18px;">총 <%=chkCount %>개의 게시글이 있습니다</b>
				
			</caption>
			<tr class="table-secondary">
				<th width="50">체크</th>
				<th width="50">번호</th>
				<th width="400">제목</th>
				<th width="130">작성자</th>
				<th width="150">작성일</th>
				<th>조회</th>	<!-- width 안주면 남은공간 활용  -->
			</tr>
				
			<%
			if(chkCount==0)
			{%>
				<tr height="40">
					<td colspan="5" align="center">
						<h6><b>등록된 게시글이 없습니다</b></h6>
					</td>
				</tr>
			<%}else{
				
				for(int i=0;i<list.size();i++)
				{
					//dto 선언
					CarsellerDto dto=list.get(i);
					%>
					<tr>
						<td align="center">
							<input type="checkbox" name="chkbox">
						</td>
						<%-- <td><%=dto.getNum() %></td> --%>
						<!-- 실제 시퀀스넘버는 노출시키지않으며, 게시글을 삭제했을경우에 그 번호는 사용불가-->
						<td align="center"><%=chkCount-i %></td>
						<!-- 글번호는 유지하는걸로 -->
						<td>
							<a href="detailview.jsp?num=<%=dto.getNum() %>">
								<%=dto.getCarname()%> / <%=dto.getCarcolor()%> / <%=dto.getCaryear() %>년식
							</a>
						</td>
						<td align="center"><%=dto.getWriter() %></td>
						<td align="center"><%=dt.format(dto.getWriteday()) %></td>
						<td align="center"><%=dto.getReadcount() %></td>
					</tr>
				<% }
			} %>
			<caption>
				<button type="button" class="btn btn-warning"
				onclick="location.href='interestboard.jsp'"
				style="width: 120px; ">
				<b class="bi bi-check-square"></b> 관심글 해제 / 미완성</button>
				
				<button type="button" class="btn btn-success"
				onclick="location.href='carboard.jsp'"
				style="width: 120px; margin-left: 10px">
				<b class="bi bi-list-ul"></b> 전체 목록</button>
			
				<button type="button" class="btn btn-outline-secondary"
				onclick="location.href='interestboard.jsp'"
				style="width: 120px; margin-left: 465px;">
				<b class="bi bi-currency-dollar"></b> 구매하기</button>
			</caption>
		</table>
	</div>
</body>
</html>