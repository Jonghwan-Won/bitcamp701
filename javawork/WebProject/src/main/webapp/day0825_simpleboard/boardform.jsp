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
</head>
<body>
	<div style="margin: 30px 30px; width: 400px;">
		<form action="boardaction.jsp" method="post">
			<table class="table table-bordered">
				<caption align="top"><h5><b><i class="bi bi-pencil-fill"></i>글쓰기</b></h5></caption>
				<tr>
					<th width="100" class="table-secondary">작성자</th>
					<td>
						<input type="text" name="writer" class="form-control form-control-sm"
						required="required" autofocus="autofocus" style="width: 150px">
						<!-- autofoucs : 커서가 자동으로 위치하며 form 안에서 한군데에만 줄 수 있음 -->
					</td>
				</tr>
				<tr>
					<th width="100" class="table-secondary">비밀번호</th>
					<td>
						<input type="password" name="pass" class="form-control form-control-sm"
						required="required" style="width: 150px" 
						pattern="[0-9]{4,10}">
						<!-- pattern : submit일때만 적용됨 -->
						<!-- [0-9] : 숫자0~9 만 입력받기 -->
						<!-- {4,10} : 최소 4자리 ~ 최대 10자리 -->
					</td>
				</tr>
				<tr>
					<th width="100" class="table-secondary">제 목</th>
					<td>
						<input type="text" name="subject" class="form-control form-control-sm"
						required="required">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<label for="comment">Comments:</label>
						<textarea class="form-control" id="comment" name="content" 
						required="required" style="width: 100%; height: 100px;"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<!-- submit 기능을 이미지로 -->
						<!-- input type이 image거나 submit일 경우 기본 기능이 submit입니다 -->
						<label>
							<input type="image" src="../image/submit_btn.png" style="width: 20px;">
							<b class="submit" style="margin-right: 20px;">작성완료</b>
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