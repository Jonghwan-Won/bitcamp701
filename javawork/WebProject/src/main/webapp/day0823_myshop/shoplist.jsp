<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="data.dto.MyShopDto"%>
<%@page import="java.util.List"%>
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

</style>
</head>
<body>
	<%
		//db를 가져오기위해 dao 선언
		MyShopDao dao=new MyShopDao();
	
		//전체 목록 가져오기
		//MyShopDao에서 반환된 list를 받음
		List<MyShopDto> list=dao.getAllSangpums();
	%>

	<div style="margin: 30px 30px;">
		<h3 class="alert alert-danger" style="width: 800px;">MyShop 목록</h3>
		<button type="button" class="btn btn-info btn-sm"
		onclick="location.href='shopform.jsp'">상품 추가</button>
		<br><br>
		<table class="table table-bordered" style="width: 800px;">
			<tr class="table-info">
				<th width="50">번호</th>
				<th width="300">상품명</th>
				<th width="60">색상</th>
				<th width="100">가격</th>
				<th width="150">입고일</th>
				<th width="200">등록일</th>
			</tr>
			
			<%
				if(list.size()==0){%>
					<tr>
						<td colspan="6" align="center"> 
							<h3><b>등록된 상품이 없습니다</b></h3>
						</td>
					</tr>
				<%} else{
					NumberFormat nf=NumberFormat.getCurrencyInstance();
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH시");
					
					for(int i=0;i<list.size();i++){
						MyShopDto dto=list.get(i);
					%>
					<tr>
						<td align="center"><%=i+1 %></td>
						<td>
							<!-- 사진과 함께 제목이 나오도록 -->
							<img src="../image2/<%=dto.getPhoto() %>.jpg"
							width="60" height="60" class="img-thumbnail">
								<!-- 상품명 클릭시 디테일뷰로 연결(나중에) -->
								<a href="detailview.jsp?num=<%=dto.getNum() %>" style="color: black; text-decoration: none;">
									<b><%=dto.getSangpum() %></b>
								</a>
						</td>
						<td style="background-color: <%=dto.getColor()%>">
								<%=dto.getColor()%>
						</td>
						<td align="right"><%=nf.format(dto.getPrice()) %></td>
						<!-- nf.format을 사용하지 않았으면 단순히 숫자(가격)만 출력됨 -->
						<td align="center"><%=dto.getIpgoday() %></td>
						<td align="center">
							<%=sdf.format(dto.getWriteday())%> <br>
							
							<button type="button" class="btn btn-outline-info btn-sm"
							onclick="location.href='updateform.jsp?num=<%=dto.getNum()%>'">수정</button>
							
							<button type="button" class="btn btn-outline-danger btn-sm"
							onclick="location.href='deleteshop.jsp?num=<%=dto.getNum()%>'">삭제</button>
						</td>
					</tr>
					
					<%}
				}
			%>
		</table>
	</div>
</body>
</html>