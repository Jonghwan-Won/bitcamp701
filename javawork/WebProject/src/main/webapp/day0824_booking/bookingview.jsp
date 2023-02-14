<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="data.dto.BookingDto"%>
<%@page import="data.dao.BookingDao"%>
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

	td>button{
		width: 100px;
	}
	
</style>

<script type="text/javascript">
	function funcdel(num) {
		//삭제버튼에서 보낸 num값 확인
		//alert(num);
		
		var a=confirm("해당 주문사항을 삭제하려면 [확인]을 눌러주세요");
		//확인 클릭 시 a는 true
		if(a){
			location.href="deletebooking.jsp?num="+num;
		}
		
	}
</script>
</head>
<body>
<%
	//num 읽기
	String num=request.getParameter("num");
	
	//dao 선언
	BookingDao dao=new BookingDao();
	
	//num에 해당하는 dto 얻기
	BookingDto dto=dao.getBooking(num);
	
	//NumberFormat, SimpleDateFormat
	NumberFormat nf= NumberFormat.getCurrencyInstance();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	//dto 데이터를 출력하는데
	//foodphoto 는 컴마로 분리해서 이미지로 출력
	String []fphoto=dto.getFoodphoto().split(",");
	
	//foodprice 는 컴마로 분리해서 반복문에서 총 금액에 더하는데
	//이때 int로 변환 후 더해야한다
	String []fprice=dto.getFoodprice().split(",");
	
	int totalmoney=0; //총금액
	

%>
<div style="margin: 30px 30px; width: 700px;">
	<h4 class="alert alert-danger">예약 상세보기</h4>
	<table class="table table-bordered">
	<tr>
		<th width="150" style="background-color: pink">예약자명 </th>
		<td>
			<img src="../image/<%=dto.getGender().equalsIgnoreCase("m")?"male":"female" %>.png" width="50">
			&nbsp;
			<%=dto.getName() %>
		</td>
	</tr>
	<tr>
		<th width="150" style="background-color: pink">예약시간 </th>
		<td><%=dto.getBookday() %></td>
	</tr>
	<tr>
		<th width="150" style="background-color: pink">예약인원수 </th>
		<td><%=dto.getInwon() %></td>
	</tr>
	<tr>
		<th width="150" style="background-color: pink">주문한시간 </th>
		<td><%=sdf.format(dto.getWriteday()) %></td>
	</tr>
	<tr>
		<th width="150" style="background-color: pink">주문메세지 </th>
		<td>
			<pre style="font-family: 'Jua';"><%=dto.getMessage() %></pre>
		</td>
	</tr>
	<tr>
		<th width="150" style="background-color: pink">주문메뉴 </th>
		<td>
			<%
			for(int i=0;i<fphoto.length;i++)
			{
				//숫자 형태라도 문자열이므로 int 타입으로 변환 후 계산한다
				int price=Integer.parseInt(fprice[i]);
				totalmoney+=price;	//같은 변수에 계속 더해야 총 금액을 구할 수 있다
				
				//이미지명에서 확장자를 뺀 파일명만 분리하기(split으로 분리해도됨)
				//. 의 위치 얻기
				int dotloc=fphoto[i].indexOf('.');
				
				//. 의 위치 전 까지 분리하기
				String menuname=fphoto[i].substring(0,dotloc);
				
				
				
				//방법2 - split으로 분리하기
				//String []m=fphoto[i.split("[.]");
				//m[0] 으로 출력하면 됨
				
			%>
			
			<div class="input-group">
				<!-- 사진 출력 -->
				<img src="../image/<%=fphoto[i]%>" width="80" height="80" border="1" 
				style="margin-left: 30px; margin-bottom: 5px;">
				
				<!-- 사진(메뉴) 이름 출력 -->
				<h4 style="width: 200px;margin-left: 30px;"><%=menuname %></h4>
				&nbsp;
				
				<!-- 가격 출력 : price를 format에 맞게 변환 -->
				<%=nf.format(price) %>
				<br>
				
			<%} %>
			
			<h3>총 결제 금액 : <%=nf.format(totalmoney) %></h3>
			
			</div>
			
		</td>
	</tr>
	
	
	<tr>
		<td colspan="2" align="center">
			<button type="button" class="btn btn-warning"
			onclick="location.href='bookingupdateform.jsp?num=<%=num%>'">수정</button>
			&nbsp;
			<button type="button" class="btn btn-danger"
			onclick="funcdel('<%=num%>')">삭제</button>
			<!-- script 에 해당 함수를 만들기 -->
			&nbsp;
			<button type="button" class="btn btn-info"
			onclick="location.href='startbooking.jsp'">목록</button>
		</td>
	</tr>
	</table>
</div>
</body>
</html>