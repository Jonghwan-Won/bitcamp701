<%@page import="data.dao.SmartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//nums 읽기
	String nums=request.getParameter("nums");
	
	//,로 분리하기 변수 String [] num
	String []num=nums.split(",");

	//dao 선언
	SmartDao dao=new SmartDao();
	
	//for문으로 num갯수만큼 반복해서 delete 메소드 호출
	/* 
	for(int i=0;i<num.length;i++)
	{
		dao.deleteSmart(num[i]);
	}
	 */
	for(String a:num)
	{
		dao.deleteSmart(a);
	}
	
	//목록으로 이동
	response.sendRedirect("smartlist.jsp");

%>