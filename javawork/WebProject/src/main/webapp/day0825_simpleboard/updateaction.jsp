<%@page import="data.dao.SimpleBoardDao"%>
<%@page import="data.dto.SimpleBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	//엔코딩
    	request.setCharacterEncoding("utf-8");
    
    	//데이터 읽기(updateform에서 넘어온 값을 변수에 담기)
    	String num=request.getParameter("num");
    	String writer=request.getParameter("writer");
    	String subject=request.getParameter("subject");
    	String content=request.getParameter("content");
    	
    	//dto에 담기
    	SimpleBoardDto dto=new SimpleBoardDto();
    	
    	dto.setNum(num);
    	dto.setWriter(writer);
    	dto.setSubject(subject);
    	dto.setContent(content);
    	
    	//dao 선언 (updateBoard 사용하기위해)
    	SimpleBoardDao dao=new SimpleBoardDao();
    	
    	//updateBoard 메서드 호출(dto에 저장한 값을 전달)
    	dao.updateBoard(dto);
    	
    	//contentview 화면으로 이동
    	response.sendRedirect("contentview.jsp?num="+num);
    
    %>
 
<%--     선생님 방법 - useBean
    
   <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//post 타입이므로 엔코딩
	request.setCharacterEncoding("utf-8");

%>
	<!-- useBean은 new로 객체 생성하는것과 같다, id는 변수명이 된다 -->
	<!-- 스크립트릿 안에서 SimpleboardDao dao=new SimpleBoardDao(); 하는것과 같음 -->
	<jsp:useBean id="dao" class="data.dao.SimpleBoardDao"/>
	<jsp:useBean id="dto" class="data.dto.SimpleBoardDto"/>
	
	<!-- dto의 멤버와 같은이름의 폼태그(*)는 자동으로 읽어서 dto에 넣어주기 -->
	<!-- name 에는 위에서 생성된 id명을 준다 -->
	<jsp:setProperty property="*" name="dto"/>

<%
	//db에 update
	dao.updateBoard(dto);
	
	//내용보기로 이동
	//방금 insert된 num값을 알아야한다
	response.sendRedirect("contentview.jsp?num="+num);
	
%> --%>
   
