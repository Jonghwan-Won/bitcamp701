<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Anton&family=Edu+VIC+WA+NT+Beginner&family=Gamja+Flower&family=Jua&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@300&family=Single+Day&family=Sunflower&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<style type="text/css">
	*{
		font-family: 'Noto Sans KR';
	}
	
	body {
		background-color: #f5f5f5;
	}
	
	div.reg{
		margin: 150px auto;
	}
	
	h2{
		font-family: 'sun flower';
	}

	div.head{
		font-family: 'Sunflower';
		margin-left: 92px;
		margin-top: 49px;
	}
	
	a {
		color: black;
		text-decoration: none;
	}
	
	a:hover{
		color: black;
	}

</style>
</head>
<body>
	<div class="head">
		<a class="navbar-brand" href="boardlist.jsp">
			<b style="font-size: 28px;">devlog</b>
		</a>
	</div>
	<div class="reg" style="width: 400px; height: 400px;">
		<form action="registeraction.jsp">
			<div class="mb-3">
				<h2 style="color: black;">환영합니다!</h2><br>
			</div>
			<div class="mb-3">
				<label for="pwd" class="form-label">사용자 이름:</label>
				<input type="text" class="form-control" placeholder="이름을 입력해주세요"
				 name="username" required="required">
			</div>
			<div class="mb-3">
				<label for="pwd" class="form-label">ID 입력:</label>
				<input type="text" class="form-control" placeholder="ID를 입력해주세요"
				 name="userid" required="required" pattern="[a-z]{3,8}">
			</div>
			<div class="mb-3">
				<label for="pwd" class="form-label">비밀번호 :</label>
				<input type="password" class="form-control" placeholder="비밀번호를 입력해주세요"
				 name="userpass" required="required" pattern="[0-9]{3,}">
			</div>
			<br>
			<button type="button" class="btn btn-secondary"
			onclick="history.back()" style="margin-right: 10px;">돌아가기</button>
			<button type="submit" class="btn btn-success" style="width: 300px">가입하기</button>&nbsp;&nbsp;
			
		</form>

	</div>
</body>
</html>