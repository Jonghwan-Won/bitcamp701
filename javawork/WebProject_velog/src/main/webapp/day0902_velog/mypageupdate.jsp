<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.VelogUserDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.VelogUserDao"%>
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
		margin: 100px 100px;
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
	
	#blah{
		position: absolute;
		left: 530px;
		top: 565px;
		width: 80px;
		border: 1px solid lightgray;
	}

</style>

<script type="text/javascript">
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#blah').attr('src', e.target.result);
        };

        reader.readAsDataURL(input.files[0]);
    }
}
</script>

</head>

<%
	//dao 선언
	VelogUserDao dao=new VelogUserDao();

	//session가져오기
	String num=(String)session.getAttribute("num");

	//dto list에 담아둔 getUser 가져오기
	VelogUserDto dto=dao.getUser(num);
	
	//날짜형식
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
		
%>
<body>
	<div class="head">
		<a class="navbar-brand" href="boardlist.jsp">
			<b style="font-size: 28px;">devlog</b>
		</a>
	</div>

	<div class="a" style="width: 400px; height: 400px;">
		<form action="mypageaction.jsp"  method="post" enctype="multipart/form-data">
			<div class="mb-3">
				<h2 style="color: black;">개인정보 수정</h2><br>
			</div>
			<input type="hidden" name="num" value="<%=dto.getNum()%>">
			<div class="mb-3">
				<label class="form-label">사용자 이름 :</label>
				<input type="text" class="form-control" value="<%=dto.getUsername() %>" name="username">
			</div>
			<input type="hidden" name="userid" value="<%=dto.getUserid()%>">
			<%-- 
			<div class="mb-3">
				<label class="form-label">ID 입력:</label>
				<input type="text" class="form-control" value="<%=dto.getUserid() %>" name="userid">
			</div>
			 --%>
			
			<div class="mb-3">
				<label class="form-label">비밀번호 :</label>
				<input type="password" class="form-control" value="<%=dto.getUserpass() %>" name="userpass">
			</div>
			<div class="mb-3">
				<label class="form-label">한 줄 메모:</label>
				<input type="text" class="form-control" value="<%=dto.getComment() %>" name="comment">
			</div>
			<div class="mb-3">
				<label class="form-label">프로필 이미지:</label>
				<input type="file" class="form-control" name="pimg" onchange="readURL(this);">
			</div>
			

			<br>
			<button type="submit" class="btn btn-success" style="width: 400px">수정하기</button>
			
		</form>

	</div>
	
			<div style="margin: 80px 30px; width: 800px;">
			<img id="blah" src="../userphoto/<%=dto.getPimg() %>"
			 onerror="this.onerror=null; this.src='../image/user_default.png'">
</body>
</html>