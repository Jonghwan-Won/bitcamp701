<%@page import="data.dao.VelogDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//num 읽기
	String num=request.getParameter("num");
	
	
	//dao선언
	VelogDao dao=new VelogDao();
	
	//삭제 메서드 호출
	dao.deleteboard(num);
	
	//목록 보던 페이지로 이동
	response.sendRedirect("boardlist.jsp");

%>
