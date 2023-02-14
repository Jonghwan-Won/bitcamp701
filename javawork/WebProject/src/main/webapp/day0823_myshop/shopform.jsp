<%@page import="java.sql.Date"%>
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

<script type="text/javascript">
	$(function () {
		//select 의 선택된 값 얻기
		var srcImg=$("#photo").val();
		//작은 이미지의 src에 넣어준다
		$("#myphoto").attr("src","../image2/"+srcImg+".jpg");
	});
</script>
</head>
<body>
	<div style="margin: 30px 30px;">
		<form action="addaction.jsp" method="post">
		<!-- jQuery에서는 대부분 get
		JSP에서는 대부분 post 사용(URL에 입력값이 안보임)-->
			<table class="table table-bordered" style="width: 400px;">
				<caption align="top"><h4><b>상품등록</b></h4></caption>
				<tr>
					<th width="100" style="background-color: #48d1cc">상품명</th>
					<td>
						<input type="text" name="sangpum" required="required"
						class="form-control">
						<!-- 빈 문자열로 insert되는걸 방지하기위한 required 필수입력값 속성 부여 -->
						<!-- submit일때만 가능하고 button 타입은 required 사용 불가함 -->
					</td>
				</tr>
				
				<tr>
					<th width="100" style="background-color: #48d1cc">상품사진</th>
					<td>
						<div class="input-group">
						<select name="photo"  class="form-select" style="width: 150px;" id="photo">
							<option value="11">단화</option>
							<option value="10">스카프</option>
							<option value="29">모자</option>
							<option value="31">화이트자켓</option>
							<option value="33">원피스</option>
							<option value="26">머리끈</option>
							<option value="30">머리띠</option>
						</select>
						<img src="" width="40" height="40" id="myphoto">
						</div>
						
							<script type="text/javascript">
								//select 변경 시 사진도 변경되도록 이벤트 추가하기
								$("#photo").change(function() {
									var src="../image2/"+$(this).val()+".jpg";
									$("#myphoto").attr("src",src);
								});
							</script>
					</td>
				</tr>
				
				<tr>
					<th width="100" style="background-color: #48d1cc">색상</th>
					<td>
						<input type="color" name="color" value="#ffc0cb"
						class="form-control" style="width: 100px;">
					</td>
				</tr>
				
				<tr>
					<th width="100" style="background-color: #48d1cc">가격</th>
					<td>
						<input type="text" name="price" required="required"
						class="form-control" pattern="[0-9]{3,}"> <!-- 0~9만 입력가능, 3글자 이상 -->
						<!-- pattern 속성을 통해 숫자만 받을 수 있음 -->
					</td>
				</tr>
				
				<tr>
					<th width="100" style="background-color: #48d1cc">입고일</th>
					<td>
						<input type="date" name="ipgoday" value="2022-08-22" 
						class="form-control">
						
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-success">상품저장</button>
						<button type="button" class="btn btn-info"
						onclick="location.href='shoplist.jsp'">상품목록</button>
					</td>
				</tr>
				
			</table>
		</form>
	
	
	</div>
</body>
</html>