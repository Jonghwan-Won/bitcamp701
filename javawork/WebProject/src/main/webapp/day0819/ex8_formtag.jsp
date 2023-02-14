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
	<div style="margin-left: 100px;">
	<form action="ex8_action.jsp" method="post">
	<!-- post 는 내가 입력한 값이 url에서 절대 안보임 -->
	
		<table class="table table-bordered" style="width: 500px">
		
		
		<caption align="top">Ex8번 폼</caption>
		<tr>
			<th width="150px" class="table-info">이름</th>
			<td>
				<input type="text" name="irum" class="form-control">
			</td>
		</tr>
		
		<tr>
			<th width="150px" class="table-info">성별</th>
			<td>
				<label><input type="radio" name="gender" value="man">남자</label> &nbsp;
				<label><input type="radio" name="gender" value="woman">여자</label>		
			</td>
		</tr>
		
		<tr>
			<th width=150px class="table-info">백신 여부</th>
			<td>
				<label><input type="checkbox" name="vaccine">접종 완료</label>
			</td>
		</tr>
		
		<tr>
			<th width="150px" class="table-info">좋아하는 메뉴</th>
			<td>
				<label><input type="checkbox" name="menu" value="../image/1.jpg">에그샌드</label>&nbsp;
				<label><input type="checkbox" name="menu" value="../image/2.jpg">닭꼬치</label>&nbsp;
				<label><input type="checkbox" name="menu" value="../image/3.jpg">육칼면</label>&nbsp;<br>
				<label><input type="checkbox" name="menu" value="../image/4.jpg">비프스튜</label>&nbsp;
				<label><input type="checkbox" name="menu" value="../image/5.jpg">콘치즈</label>&nbsp;
				<label><input type="checkbox" name="menu" value="../image/6.jpg">볶음밥</label>&nbsp;
			</td>
		</tr>
		
		<tr>
			<th width="150px" class="table-info">주소</th>
			<td>
			<select class="form-select" name="addr">
					<option value="서초구" selected="selected">서초구</option>
					<option value="강동구">강동구</option>
					<option value="강서구">강서구</option>
					<option value="강남구">강남구</option>
					<option value="강북구">강북구</option>
					<option value="영등포구">영등포구</option>
					

			</td>
		</tr>
		
		<tr>
			<th width="150px" class="table-info">하고싶은 말</th>
			<td>
				<textarea style="width: 350px; height: 100px" class="form-control" name="text"></textarea>
				<!-- pre로 받기 -->
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-danger">서버 전송</button>
				<!-- submit : 폼 단위로 전송하는것 -->
			</td>
		</tr>
			
			
			
		</table>
	</form>
	
	</div>
</body>
</html>