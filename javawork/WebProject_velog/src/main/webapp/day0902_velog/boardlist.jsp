<%@page import="data.dto.VelogUserDto"%>
<%@page import="data.dao.VelogUserDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.VelogDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.VelogDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Anton&family=Edu+VIC+WA+NT+Beginner&family=Gamja+Flower&family=Jua&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@300&family=Single+Day&family=Sunflower&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<style type="text/css">
	*{
		font-family: 'Noto Sans KR';
	}
	
	nav{
		background-color: #f5f5f5;
		/* border-bottom: 1px solid gray; */
		height: 150px;
		padding-left: 80px;
		padding-right: 18.5%;
	}
	a{
		color: black;
		text-decoration: none;
	}
	
	a:hover{
		color: black;
	}

	
	body {
		margin-left: 80px;
		background-color: #f5f5f5;
	}
	
	div.totcount{
		width: 80%;
		height: 45px;
		color: black;
		font-size: 15px;
		font-weight: bold;
		border-bottom: 1px solid gray;
	}
	
	ul.board{
 		display: flex;
 	}
 	
 	ul.board li{
 		list-style: none;
 		text-align: center;
 		margin-right: 35px;
 		margin-bottom: 20px;
 		cursor: pointer;
 		background-color:white;
 		
 		
 		width: 300px;
 		height: 400px;
 		border: 1px solid lightgray;
 		border-radius: 10px; 
	}
	
	ul.board li:hover{
 		box-shadow: 5px 5px 5px lightgray;
 		
	}

	.txt_line{
		text-overflow:ellipsis;
		overflow: hidden;
		white-space: nowrap;
		display: block;
		max-width: 260px;
		padding-left: 40px;
		border-radius: 
	}
	
	#writepost{
		/* visibility: hidden; */
	}

	div.dropdown>button{
		border: none;
		background-color: transparent;
	}

</style>

</head>

<%
	//dao 선언
	VelogDao dao=new VelogDao();


	//dto list에 담아둔 getAllData 가져오기
	List<VelogDto> list=dao.getAllData();
	
	//날짜형식
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	//totalCount 가져오기
	int totalCount=dao.getTotalCount();
	
	
	
	//로그인 성공했을때 세션 가져오기 *(String)으로 형변환 필요
	String num=(String)session.getAttribute("num");
	
	//user정보 가져오기
	VelogUserDao userdao=new VelogUserDao();
	VelogUserDto userdto=userdao.getUser(num);
	
	
%>
<body>

	<nav class="navbar navbar-expand-sm fixed-top">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="boardlist.jsp"><h3><b>devlog</b></h3></a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="mynavbar">
	      
	      <ul class="navbar-nav me-auto">

	      </ul>
	      <form class="d-flex">
	      <%if(num==null) {%>
	      	<div>
		      	<button class="btn btn-dark" type="button" id="btnsearch" onclick="location.href='searchboard.html'">
		      	<i class="bi bi-search"></i> 검색</button>&nbsp;&nbsp;
		        <button class="btn btn-primary" type="button" id="btnlogin" onclick="location.href='loginform.jsp'">로그인</button>&nbsp;&nbsp;
	        </div>
	        <%}else{ %>
	        <div style="display: flex; justify-content: flex-end;">
	       		<button class="btn btn-dark" type="button" id="btnsearch" onclick="location.href='searchboard.html'">
		        <i class="bi bi-search"></i> 검색</button>&nbsp;&nbsp;
	       		
	       		<button type="button" class="btn btn-success" style="float: right;"
					onclick="location.href='boardform.jsp'" id="writepost">
					<i class="bi bi-pencil"></i> 글쓰기</button>&nbsp;&nbsp;&nbsp;&nbsp;
		        </div>
		        
		        <div class="dropdown">
		        	<button type="button" class="dropdown-toggle" data-bs-toggle="dropdown">
				        <img src="../userphoto/<%=userdto.getPimg() %>" width="37" height="37" style="border-radius:50px;">
				        <span><%=userdto.getUsername() %>님</span>

				    </button>
				    
				    <ul class="dropdown-menu" style="padding-left: 5px;">
				    	<li><a class="dropdown-item" href="mypageupdate.jsp">
				    	<i class="bi bi-pencil-square"></i> 내 정보수정</a></li>
				    	<li><a class="dropdown-item" href="myboard.jsp">
				    	<i class="bi bi-list"></i> 내 게시글</a></li>
				    	<li><a class="dropdown-item" href="logoutaction.jsp">
				    	<i class="bi bi-door-open"></i> 로그아웃</a></li>
					</ul>
		        </div>

		        <!-- <button class="btn btn-danger" type="button" id="btnlogout" 
		        onclick="location.href='logoutaction.jsp'">로그아웃</button> -->
	      
	        <%} %>
	      </form>
	    </div>
	  </div>
	</nav>
	
	<div style="margin-top: 180px; height: 1000px;">
		
		<div class="totcount">
		<span>총 <%=dao.getTotalCount() %> 개의 게시글이 있습니다</span>
		<!-- <button type="button" class="btn btn-dark" style="float: right;"
		onclick="location.href='boardform.jsp'">글쓰기</button><br> -->
		</div><br>
			
	    <div>
	    	
		    <ul class="board">
		    <% for(int i=0;i<list.size();i++){ 
		    	VelogDto dto=list.get(i);
		    	%>
				<li class="posting">
					<a href="contentview.jsp?num=<%=dto.getNum()%>">
					<br>
					<img src="../save/<%=dto.getMainphoto()%>" 
					 onerror="this.onerror=null; this.src='../image/noimage.png'"
					 width="250" height="200" style="border:1px solid lightgray; border-radius: 10px;">
					<br><br>
					<h5><b class="txt_line"><%=dto.getSubject() %></b></h5><br><br>
					<%-- <span class="txt_line"><%=dto.getContent() %></span> --%>
					<b><%=sdf.format(dto.getWriteday())%></b><br>
					<b style="font-size: 15px;"><%=dto.getWriter() %></b>
					</a>
				</li>
			<%
			if((i+1)%4==0){ %>
				</ul><ul class="board">
		    <% }
			
		    } %>
	        </ul>
		</div>
		

	</div>
</body>
</html>
