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
	
	div.a{
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
<%
	//세션으로부터 아이디와 체크값을 얻는다
	String userid=(String)session.getAttribute("userid");
	String saveid=(String)session.getAttribute("saveid");
			
	boolean savechk=true;
	
	if(saveid==null || saveid.equals("no"))	//조건이 여러가지일경우 반드시 null조건을 먼저 쓴다
	{
		userid="";	//아이디저장을 체크하지 않은경우 아이디를 없앤다
		savechk=false;	//체크하지 않았을경우 false, 그 이외에는 초기값이 true이므로 true가 된다
		
		//조건부분을 간단하게하기위해 savechk 변수를 설정함 
	}
%>
<body>
	<div class="head">
		<a class="navbar-brand" href="boardlist.jsp">
			<b style="font-size: 28px;">devlog</b>
		</a>
	</div>

	<div class="a" style="width: 400px; height: 400px;">
		<form action="loginaction.jsp">
			<div class="mb-3">
				<h2 style="color: black;">Login</h2><br>
			</div>
			<div class="mb-3">
				<label for="pwd" class="form-label">ID 입력:</label>
				<input type="text" class="form-control" autofocus="autofocus" 
				placeholder="ID를 입력해주세요" name="userid" required="required">
			</div>
			<div class="mb-3">
				<label for="pwd" class="form-label">비밀번호 :</label>
				<input type="password" class="form-control" placeholder="비밀번호를 입력해주세요" 
				name="userpass" required="required">
			</div>
			 <%-- 
			<div class="form-check mb-3">
				<label class="form-check-label">
					<input class="form-check-input" type="checkbox"
					 name="saveid" <%=savechk?"checked":""%>> ID 기억하기
				</label>
			</div>
			  --%>
			<br>
			<button type="button" class="btn btn-primary"
			onclick="location.href='registerform.jsp'" style="margin-right: 10px;">회원가입</button>
			<button type="submit" class="btn btn-success" style="width: 300px">로그인하기</button>
			
		</form>

	</div>
</body>
</html>