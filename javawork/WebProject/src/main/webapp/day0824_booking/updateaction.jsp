<%@page import="data.dao.BookingDao"%>
<%@page import="data.dto.BookingDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//1.엔코딩
	request.setCharacterEncoding("utf-8");
	
	//데이터 읽기
	String num=request.getParameter("num");
	String name=request.getParameter("name");
	String gender=request.getParameter("gender");
	String bookday=request.getParameter("bookday");
	int inwon=Integer.parseInt(request.getParameter("inwon"));
	String message=request.getParameter("message");

	//메뉴와 가격(,로 연결해서 dto에 넣을것)
	String foodname="";
	String foodprice="";
	
	String []food=request.getParameterValues("food");
	for(String f:food)
	{
		System.out.println(f);
		//치즈샌드위치.jpg,12000
		//떡볶이.jpg,9000
		//돼지갈비.jpg,23000

		// ,(콤마) 로 분리해서 앞부분은 foodname에, 뒷부분은 foodprice에 넣고 ,(콤마) 추가
		String []data=f.split(",");
		foodname+=data[0]+",";
		foodprice+=data[1]+",";
	}
	
	//반복문을 나온 후 마지막 ,(콤마) 지우기
	foodname=foodname.substring(0,foodname.length()-1);	//마지막 한글자를 빼고 추출
	foodprice=foodprice.substring(0,foodprice.length()-1);	//마지막 한글자를 빼고 추출
	
	System.out.println(foodname);
	System.out.println(foodprice);
	
	//dto 에 담기
	BookingDto dto=new BookingDto();
	dto.setNum(num);
	dto.setName(name);
	dto.setGender(gender);
	dto.setBookday(bookday);
	dto.setFoodphoto(foodname);	
	//foodname으로 만들었어야하는데 photo로 잘못해서
	//setFoodphoto 에는 foodname
	dto.setFoodprice(foodprice);
	dto.setMessage(message);
	dto.setInwon(inwon);
	
	//dao 선언
	BookingDao dao=new BookingDao();
	
	//update 메서드 호출
	dao.updateBooking(dto);
	
	//내용보기로 이동
	response.sendRedirect("bookingview.jsp?num="+num);
%>
