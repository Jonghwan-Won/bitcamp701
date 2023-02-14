<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<%
	//get방식이므로 한글처리 필요없음
	
	//front에서 보낸 데이터를 읽는다
	String irum=request.getParameter("irum"); //(key : value) 에서 key로 받음
	String addr=request.getParameter("addr");

	//front를 보낼 데이터를 만든다
	String message=irum+"님은 "+addr+"에 살고있어요!!";
	
	//json형태로 만들어서 front로 보낸다
	//배열이 아니므로 json object사용해도됨
	JSONObject ob=new JSONObject();
	ob.put("message",message);
%>
<%=ob.toString()%>