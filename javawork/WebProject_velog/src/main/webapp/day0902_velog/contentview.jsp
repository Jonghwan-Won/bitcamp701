<%@page import="data.dto.VelogDto"%>
<%@page import="java.text.SimpleDateFormat"%>
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

	div.head{
		font-family: 'Sunflower';
		margin-left: 92px;
		margin-top: 49px;
	}

	body *{
		 font-family: 'Noto Sans KR';
	}
	
	span.day{
		color: gray;
		font-size: 15px;
	}
	
	a {
		color: black;
		text-decoration: none;
	}
	
	a:hover{
		color: black;
	}
	
	div.aaa{
		margin-top: 50px;
	}
	
	#blah{
		position: absolute;
		left: 800px;
		top: 193px;
		width: 400px;
		border: 1px solid lightgray;
		border-radius: 10px;
	}
</style>
</head>
<body>
<jsp:useBean id="dao" class="data.dao.VelogDao"/>
<%
	//로그인 성공했을때 세션id 가져오기 *(String)으로 형변환 필요
	String sessionid=(String)session.getAttribute("userid");
	

	//num을 읽는다
	String num=request.getParameter("num");
	
	//조회수 1 증가
	dao.updateReadCount(num);
	
	//dto 가져오기
	VelogDto dto=dao.getData(num);
	
	//날짜 형식
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
%>
<div class="head">
	<a class="navbar-brand" href="boardlist.jsp">
		<b style="font-size: 28px;">devlog</b>
	</a>
</div>

<div style="margin: 30px 92px; width: 700px;" class="aaa">
	<table class="table table-bordered">
		<caption align="top">
			
			<h1 style="color: black;"><b><%=dto.getSubject() %></b></h1>
		
		</caption>
		<tr>
			<td>
				<b><%=dto.getWriter()%></b>
				<span class="day"> · <%=sdf.format(dto.getWriteday()) %>
				&nbsp;&nbsp;조회 <%=dto.getReadcount()%>
				</span>
			</td>
		</tr>
		<tr height="150">
			<td>
			<%
				if(dto.getContent()==null){%>
					<h1 style="color: red;">저장된 내용 없음!</h1>
				<%}else{%>
					<!-- 엔터없이 길게 썼을 경우 500px 안에서 자동 줄넘김되게 하기 -->
					<!-- <div style="white-space:pre-wrap;word-wrap:break-word;width: 500px;"> -->
					<%=dto.getContent()%>
					<!-- </div> -->
					<!-- 스마트에디터라서 자동줄넘김 등 코드가 이미 적용되어있음 -->
				<%}
			%>	
			</td>		
		</tr>
		<tr>
			<td align="center">
			<%if(sessionid!=null) {
				if(sessionid.equals(dto.getWriter())){%>
			<div>
				<button type="button" class="btn btn-outline-primary btn-sm" style="width: 100px;"
				onclick="location.href='boardform.jsp'">
				<i class="bi bi-pencil"></i> 새글작성</button>
				
				<button type="button" class="btn btn-outline-success btn-sm" style="width: 100px;"
				onclick="location.href='updateform.jsp?num=<%=num%>'" >
				<i class='far fa-edit' style='font-size:14px'></i> 수정</button>
				
				<button type="button" class="btn btn-outline-danger btn-sm" style="width: 100px;"
				onclick="funcdel(<%=num%>)" >
				<i class="bi bi-trash"></i> 삭제</button>
				
				<button type="button" class="btn btn-secondary btn-sm" style="width: 100px;"
				onclick="location.href='boardlist.jsp'">
				<i class="bi bi-layout-text-window-reverse"></i> 목록</button>
			</div>
			<%}else{%>
				<div>
				<button type="button" class="btn btn-secondary btn-sm" style="width: 100px;"
				onclick="location.href='boardlist.jsp'">
				<i class="bi bi-layout-text-window-reverse"></i> 목록</button>
				
			</div>
				
			<% }
				}else{ %>
			<div>
				<button type="button" class="btn btn-secondary btn-sm" style="width: 100px;"
				onclick="location.href='boardlist.jsp'">
				<i class="bi bi-layout-text-window-reverse"></i> 목록</button>
				
			</div>
			<%} %>
			</td>
		</tr>
	</table>
</div>

<img id="blah" src="../save/<%=dto.getMainphoto()%>" 
	onerror="this.onerror=null; this.src='../image/noimage.png'">


 <script type="text/javascript">
	function funcdel(num){
		//alert(num);
		
		var a=confirm("삭제하려면 [확인] 버튼을 눌러주세요")
		if(a){
			location.href="deleteaction.jsp?num="+num;
		}
	}
</script>
</body>
</html>
