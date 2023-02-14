<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.MyShopDto"%>
<%@page import="data.dao.MyShopDao"%>
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
	
	h3{
		margin: 30px 30px;
		width: 800px;
		
	}
	
	table{
		border: 1px solid lightgray;
		width: 800px;
		margin-left: 30px;
	}
	
	td {
		font-size: 25px;
		width: 400px;
		padding-left: 10px;
	}
	
	#btnbox{
		text-align: center;
	}
	
	div.box{
		 width: 30px;
		 height: 30px;
		 border: 1px solid black;
		 border-radius: 50px;
		 
		 position: relative;
		 left: 20px; 
		 top: 5px;
	}

</style>
</head>
<body>

<%
	//num을 읽는다
	String num=request.getParameter("num");
	
	//dao 선언
	MyShopDao dao=new MyShopDao();
	
	//num에 해당하는 dto얻기
	MyShopDto dto=dao.getSangpum(num);
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH시 mm분");

%>
	<h3 style="margin: 30px" class="alert alert-danger">제품 상세페이지</h3>

	<table class="table-bordered">
	
		<tr>
			<td rowspan="6">
				<img src="../image2/<%=dto.getPhoto() %>.jpg" width="400px">
			</td>
		</tr>
			
		<tr>
			<td>상품명 : <%= dto.getSangpum() %></td>
		</tr>
		
		<tr>
			<td class="input-group" style="text-align: center;" valign="middle">
				색상 : <%= dto.getColor() %>
				<div class="box" style="background-color: <%=dto.getColor()%>"></div>
			</td>
			
		</tr>
		
		<tr>
			<td>가격 : <%= dto.getPrice() %></td>
		</tr>
		
		<tr>
			<td>입고일자 : <%= dto.getIpgoday() %></td>
		</tr>
		
		<tr>
			<td>등록일자 : <%= sdf.format(dto.getWriteday()) %></td>
		</tr>
		
		<tr>
			<td colspan="2" style="height: 50px;" id="btnbox">
				<button type="button" class="btn btn-info"
				onclick=history.back()>목록으로</button>
				<!-- onclick="location.href='shoplist.jsp'">목록으로</button> -->
				
				<button type="button" class="btn btn-danger"
				onclick="location.href='updateform.jsp?num=<%=dto.getNum()%>'">수정하기</button>
			</td>
		</tr>

	</table>



</body>
</html>