<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script><!-- modal -->
<style type="text/css">
	*{
		font-family: 'Jua';
	}
	
	#loginstate
	{
		float: right;
		margin-right: 100px;
		font-size: 20px;
	}
	
</style>
</head>
<body>
	<c:set var="root" value="<%=request.getContextPath() %>"/>
	<a href="${root}/" style="color: black; text-decoration: none;">
		<b style="font-size: 40px">BITCAMP701</b>
	</a>
	
	<span id="loginstate">
		<c:if test="${sessionScope.loginok==null}"> <!-- 세션영역(세션에서 찾을때 무조건써줘야함) -->
			<button type="button" class="btn btn-primary" id="btnlogin"
			data-bs-toggle="modal" data-bs-target="#myModal">로그인</button>
		</c:if>
		
		<c:if test="${sessionScope.loginok!=null}"> <!-- 세션영역(세션에서 찾을때 무조건써줘야함) -->
			<b>${sessionScope.loginname}님</b>
			&nbsp;&nbsp;
			<button type="button" class="btn btn-dark" id="btnlogout">로그아웃</button>
		</c:if>
	</span>
	
	
	
	<!-- 로그인창 -->
	<!-- The Modal -->
	<div class="modal" id="myModal">
	  <div class="modal-dialog modal-sm">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title">회원 로그인</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body">
	        <div class="input-group mb-3 input-group-sm">
			  <span class="input-group-text" style="width: 80px;">아이디</span>
			  <input type="text" class="form-control" id="loginid">
			</div>
			<div class="input-group mb-3 input-group-sm">
			  <span class="input-group-text" style="width: 80px;">비밀번호</span>
			  <input type="password" class="form-control" id="loginpass">
			</div>
	      </div>
	
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" data-bs-dismiss="modal" id="btnloginok">로그인</button>
	        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
	      </div>
	
	    </div>
	  </div>
	</div>
	
	<!-- 스크립트 이벤트 -->
	<script type="text/javascript">
		
		//modal 팝업창에 있는 로그인 버튼
		$("#btnloginok").click(function () {
			
			//아이디와 비밀번호 읽어오기
			var id=$("#loginid").val();
			var pass=$("#loginpass").val();
			var root='${root}';
			console.log("root"+root);
			
			$.ajax({
				type:"get",
				url:root+"/member/login",
				dataType:"json",
				data:{"id":id,"pass":pass},
				success:function(res){
					if(res.result=='fail'){
						alert("ID 혹은 비밀번호가 맞지 않습니다");
					}else{
						location.reload();
					}
					
				}
				
			});	//ajax 종료
		});	//로그인 버튼 이벤트 종료
		
		
		//로그아웃
		$("#btnlogout").click(function () {
			
			var root='${root}';
			
			$.ajax({
				type:"get",
				url:root+"/member/logout",
				dataType:"text",
				/* data:{"id":id,"pass":pass}, */
				success:function(res){
					
					location.reload();
				}
				
			});	//ajax 종료
		});
		
	</script>

</body>
</html>