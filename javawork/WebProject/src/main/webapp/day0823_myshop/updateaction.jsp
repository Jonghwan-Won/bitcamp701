<%@page import="data.dao.MyShopDao"%>
<%@page import="data.dto.MyShopDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	//한글 엔코딩(post방식)
    	request.setCharacterEncoding("UTF-8");
    	
    	//데이터 읽기
    	String num=request.getParameter("num");
    	
    	String sangpum=request.getParameter("sangpum");
    	String photo=request.getParameter("photo");
    	String color=request.getParameter("color");
    	int price=Integer.parseInt(request.getParameter("price"));
    	String ipgoday=request.getParameter("ipgoday");
    	
    	//dto에 담기
    	MyShopDto dto=new MyShopDto();
    	
    	dto.setNum(num);
    	
    	dto.setSangpum(sangpum);
    	dto.setPhoto(photo);
    	dto.setColor(color);
    	dto.setPrice(price);
    	dto.setIpgoday(ipgoday);
    	
    	//dao 선언
    	MyShopDao dao=new MyShopDao();
    	
    	//insert
    	//update
    	dao.updateShop(dto);
    	
    	//목록으로 이동
    	response.sendRedirect("shoplist.jsp");
    	
    %>