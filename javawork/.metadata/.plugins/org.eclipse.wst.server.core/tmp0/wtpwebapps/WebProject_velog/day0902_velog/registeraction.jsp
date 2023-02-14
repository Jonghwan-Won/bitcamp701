<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//post 타입이므로 엔코딩
	request.setCharacterEncoding("utf-8");

%>
<!-- useBean은 new로 객체 생성하는것과 같다, id는 변수명이 된다 -->
<!-- 스크립트릿 안에서 SimpleboardDao dao=new SimpleBoardDao(); 하는것과 같음 -->
<jsp:useBean id="dao" class="data.dao.VelogUserDao"/>
<jsp:useBean id="dto" class="data.dto.VelogUserDto"/>

<!-- dto의 멤버와 같은이름의 폼태그(*)는 자동으로 읽어서 dto에 넣어주기 -->
<!-- name 에는 위에서 생성된 id명을 준다 -->
<jsp:setProperty property="*" name="dto"/>

<%
	//db에 insert
	dao.insertUser(dto);

	out.println("<script>alert('계정이 등록 되었습니다'); location.href='loginform.jsp';</script>");

	//loginform으로 이동
	//response.sendRedirect("loginform.jsp");


	
%>

