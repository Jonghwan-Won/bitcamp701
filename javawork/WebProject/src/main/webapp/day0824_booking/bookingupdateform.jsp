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

</style>
<script>
	/* checkbox 는 원래 아무것도 체크하지않아도 문제없으나 */
	/* submit 타입의 버튼을 눌렀을때 action보다 onsubmit이 먼저 실행되고 */
	/* onsubmit 함수를 script 에서 만든다 */
	function check() {
		var len=$("input[name='food']:checked").length;
		if(len<2){
			alert("주문 메뉴는 최소 2개 이상 선택해주세요");
			return false;
		}
	}
</script>
</head>

<%
	//num 읽기
	String num=request.getParameter("num");
	
	//dao 선언
	BookingDao dao=new BookingDao();
	
	//num 에 해당하는 dto 얻기
	BookingDto dto=dao.getBooking(num);
%>


<body>
	<div style="margin: 30px 30px;">
	<!-- onsubmit 이벤트는 action이 호출되기 전에 발생 -->
	<!-- 리턴값을 false로 받으면 action이 호출되지 않음 -->
		<form action="updateaction.jsp" method="post" onsubmit="return check()">
		
		<input type="hidden" name="num" value="<%=num %>">
		<!-- update는 num을 hidden으로 넘기는게 중요! -->
		
			<table class="table table-bordered" style="width: 750px;">
			<caption align="top"><h4><b>예약 수정하기</b></h4></caption>
				<tr>
					<th width="100" style="background-color: #b0e0e6">예약자명 </th>
					<td>
						<input type="text" name="name" class="form-control" placeholder="예약자이름"
						 required="required" style="width: 200px;"
						 value="<%=dto.getName()%>">
					</td>
				</tr>
				<tr>
					<th width="100" style="background-color: #b0e0e6">성별 </th>
					<td>
						<label>
							<input type="radio" name="gender" value="f"
							<%=dto.getGender().equalsIgnoreCase("f")?"checked":"" %>>
							
							<img src="../image/female.png" width="50">
						</label>
						&nbsp;
						<label>
							<input type="radio" name="gender" value="m"
							<%=dto.getGender().equalsIgnoreCase("m")?"checked":"" %>>
							
							<img src="../image/male.png" width="50">
						</label>
					</td>
				</tr>
				<tr>
					<th width="100" style="background-color: #b0e0e6">예약시간 </th>
					<td>
						<input type="datetime-local" name="bookday" class="form-control"
						style="width: 220px" required="required"
						value="<%=dto.getBookday() %>">
					</td>
				</tr>
				<tr>
					<th width="100" style="background-color: #b0e0e6">인원수 </th>
					<td>
						<input type="number" name="inwon" min="1" max="6" 
						class="form-control" style="width: 80px"
						value="<%=dto.getInwon()%>">
					</td>
				</tr>
				<tr>
					<th width="100" style="background-color: #b0e0e6">메뉴선택 </th>
					<td>
						<%
							//출력할 메뉴명
							String []inpFood={"치즈샌드위치.jpg","떡볶이.jpg","돼지갈비.jpg","똠양꿍.jpg","알밥.jpg","초밥.jpg"};
							//출력할 가격
							String []inpPrice={"12000","9000","23000","17000","13000","30000"};
							//출력할 제목
							//String []title={"치즈샌드","떡볶이","돼지갈비","똠양꿍","알밥","초밥"};
							
							//db에 저장된 선택메뉴들
							String []selectFood=dto.getFoodphoto().split(",");
						
							for(int i=0;i<inpFood.length;i++)
							{
								//이미지명에서 파일이름만 추출
								int dot=inpFood[i].indexOf('.');
								//. 위치 전 까지 추출
								String title=inpFood[i].substring(0,dot);
								//title의 길이가 4글자 이상이면 4글자까지만 추출하기
								if(title.length()>4)
									title=title.substring(0,4);	//0~3까지 추출(한글도 한글자가 1)
								
								boolean find=false;
								
								for(int j=0;j<selectFood.length;j++)
								{
									//출력할 파일명이 db의 선택된 파일명과 같은지 비교후
									//존재할경우 true
									if(inpFood[i].equals(selectFood[j]))
										find=true;
								}
								%>
								<label>
									<input type="checkbox" name="food" value="<%=inpFood[i]%>,<%=inpPrice[i]%>"
									<%=find?"checked":""%>>
									<%-- <%=title[i] %><br> --%>
									<%=title %><br>
									<img src="../image/<%=inpFood[i]%>" width="80" height="80" border="1">
								</label>
								<%
							}
						 %>
						
					</td>
				</tr>
				<tr>
					<th width="100" style="background-color: #b0e0e6">메세지 </th>
					<td>
						<textarea style="width: 500px; height: 80px"; class="form-control"
						required="required" name="message"><%=dto.getMessage() %></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-outline-danger"
						style="width: 120px;">예약수정</button>
						<button type="reset" class="btn btn-outline-danger"
						style="width: 120px;">다시하기</button>
						<button type="button" class="btn btn-outline-danger"
						style="width: 120px;" onclick="location.href='startbooking.jsp'">예약목록</button>
					</td>
				</tr>

			</table>

		</form>
</body>
</html>