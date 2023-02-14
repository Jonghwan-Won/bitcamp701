<%@page import="data.dao.SmartAnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//idx 읽기
	String idx=request.getParameter("idx");
	
	//dao 선언
	SmartAnswerDao dao=new SmartAnswerDao();
	
	//dao의 deleteAnswer 호출 (idx값 보내기)
	dao.deleteAnswer(idx);

%>