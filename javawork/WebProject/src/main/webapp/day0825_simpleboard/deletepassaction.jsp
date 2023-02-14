<%@page import="data.dao.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//num 읽어와서 변수에 담기
	String num=request.getParameter("num");
	String pass=request.getParameter("pass");

	//dao 메서드 호출을 위한 선언
	SimpleBoardDao dao=new SimpleBoardDao();
	
	//비밀번호 맞는지 체크
	boolean check=dao.isPassCheck(num, pass); //isPassCheck에 num 과 pass값 전달
	
	//해당 num에 대한 게시글의 비밀번호가 일치한다면 삭제
	if(check){
		dao.deleteBoard(num);
		//리스트로 이동
		response.sendRedirect("boardlist.jsp");
		
		//num과 pass가 일치하지않다면 alert 발생
	}else{%>
		<!-- 삭제 알림창 후 list로 이동까지 하려면 둘 다 script로 해야함 -->
		<!-- 두개를 섞어서 하게되면 둘중 하나가 안되는 오류가 발생 -->	
		<script>
			alert("비밀번호가 일치하지 않습니다");
			history.back();
		</script>
	<% }
	
	
%>

