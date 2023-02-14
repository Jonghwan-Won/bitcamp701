<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<%
	String photono=request.getParameter("photono");
	String photofood=request.getParameter("photofood");
	String java=request.getParameter("java");
	String jquery=request.getParameter("jquery");
	String html=request.getParameter("html");

	
	//총점
	int total=Integer.parseInt(java)+Integer.parseInt(jquery)+Integer.parseInt(html);
	
	//평균
	double avge=total/3.0;
	
	JSONObject ob=new JSONObject();
	
	ob.put("photo", "../image/"+photono+".jpg");
	ob.put("food", photofood);
	ob.put("tot", total);
	ob.put("avg", avge);	//avge 값을 'avg'에 담아서 res에보낸다
%>
<%= ob.toString()%>
