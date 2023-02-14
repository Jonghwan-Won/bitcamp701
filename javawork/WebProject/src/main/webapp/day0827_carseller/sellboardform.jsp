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

</style>
</head>
<body>
	<div style="margin: 50px auto; width: 700px;">
		<form action="saveaction.jsp" method="post">
			<table class="table table-bordered">
				<caption align="top"><h3><b><i class="bi bi-pencil-fill"></i>새글 쓰기</b></h3></caption>
				<tr>
					<th width="100" class="table-secondary">작성자</th>
					<td colspan="3">
						<input type="text" name="writer" class="form-control form-control-sm"
						required="required" autofocus="autofocus" style="width: 150px">
						<!-- autofoucs : 커서가 자동으로 위치하며 form 안에서 한군데에만 줄 수 있음 -->
					</td>
				</tr>
				<tr>
					<th width="100" class="table-secondary">비밀번호</th>
					<td colspan="3">
						<input type="password" name="pass" class="form-control form-control-sm"
						required="required" style="width: 150px" 
						pattern="[0-9]{4,10}">
						<!-- pattern : submit일때만 적용됨 -->
						<!-- [0-9] : 숫자0~9 만 입력받기 -->
						<!-- {4,10} : 최소 4자리 ~ 최대 10자리 -->
					</td>
				</tr>
				<tr>
					<th width="100" class="table-secondary">차량 모델</th>
					<td>
						<select class="form-select" name="carname"  style="width: 200px;">
							<option value="" selected disabled hidden>차량 선택</option>
						    <option value="아반떼">현대 아반떼</option>
						    <option value="소나타">현대 소나타</option>
						    <option value="그랜저">현대 그랜저</option>
						    <option value="팰리세이드">현대 팰리세이드</option>
						    <option value="아이오닉5">현대 아이오닉5</option>
						    <option value="아이오닉6">현대 아이오닉6</option>
						    <option value="G70">현대 G70</option>
						    <option value="G80">현대 G80</option>
						    <option value="G90">현대 G90</option>
						    <option value="GV70">현대 GV70</option>
						    <option value="GV80">현대 GV80</option>
						    <option value="K3">기아 K3</option>
						    <option value="K5">기아 K5</option>
						    <option value="K7">기아 K7</option>
						    <option value="K8">기아 K8</option>
						    <option value="K9">기아 K9</option>
						    <option value="EV6">기아 EV6</option>
						    <option value="셀토스">기아 셀토스</option>
						    <option value="니로">기아 니로</option>
						    <option value="스포티지">기아 스포티지</option>
						    <option value="쏘렌토">기아 쏘렌토</option>
						</select>
						<!-- <input type="text" name="subject" class="form-control form-control-sm"
						required="required" style="width: 200px;"> -->
					</td>
					<th width="100" class="table-secondary">차량 색상</th>
					<td>
						<input type="color" name="carcolor" class="form-control form-control-color" value="#CCCCCC">
						<!-- <input type="text" name="subject" class="form-control form-control-sm"
						required="required" style="width: 200px;"> -->
					</td>
				</tr>

				<tr>
					<th width="100" class="table-secondary">차량 연식</th>
					<td>
						<input type="text" name="caryear" class="form-control form-control-sm"
						required="required" style="width: 200px;" placeholder="숫자만 입력"
						pattern="^[0-9]{4,4}">
					</td>
					<th width="100" class="table-secondary";>차량 가격</th>
					<td>
						<input type="text" name="carprice" class="form-control form-control-sm"
						required="required" style="width: 200px;" placeholder="예시) 4000" pattern="[0-9]{4,5}">
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<label for="comment">내용 작성</label>
						<textarea class="form-control" id="comment" name="content" 
						required="required" style="width: 100%; height: 150px;"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="right">
						<!-- submit 기능을 이미지로 -->
						<!-- input type이 image거나 submit일 경우 기본 기능이 submit입니다 -->
						<button type="submit" class="btn btn-success"
						style="margin-right: 10px;">저장하기</button>
						
						<button type="button" class="btn btn-secondary"
						style="margin-right: 10px;"
						onclick="location.href='carboard.jsp'">목록으로</button>
					</td>
				</tr>
			
			</table>
		</form>
	
	</div>
</body>
</html>